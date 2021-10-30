package silveira.caio.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import silveira.caio.domain.exception.ServiceException;
import silveira.caio.domain.model.Cliente;
import silveira.caio.domain.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	@Transactional
	public Cliente salvar(Cliente clie) {
		boolean emailDuplicado = repo.findByEmail(clie.getEmail()).stream()
				.anyMatch(c -> !c.equals(clie));
		
		if(emailDuplicado) throw new ServiceException("Já existe esse e-mail em outro cliente");
		
		return repo.save(clie);
	}
	
	@Transactional
	public void remover(Long id) {
		repo.deleteById(id);
	}
	
	
	
	
	
}
