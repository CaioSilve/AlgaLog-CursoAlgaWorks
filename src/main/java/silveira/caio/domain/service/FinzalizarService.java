package silveira.caio.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import silveira.caio.domain.model.Entrega;
import silveira.caio.domain.repository.EntregaRepository;

@Service
public class FinzalizarService {

	
	@Autowired
	private BuscaEntrega buscaEntrega;
	
	@Autowired
	private EntregaRepository repoEntrega;


	@Transactional
	public void finalizar(Long entregaId) {
		Entrega ent = buscaEntrega.busca(entregaId);
		
		ent.finalizar();
		
		repoEntrega.save(ent);
	}


}
