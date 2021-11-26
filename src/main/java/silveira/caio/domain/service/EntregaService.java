package silveira.caio.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import silveira.caio.domain.model.Entrega;
import silveira.caio.domain.model.StatusEntrega;
import silveira.caio.domain.repository.EntregaRepository;

@Service
public class EntregaService {

	@Autowired
	private EntregaRepository repo;
	
	@Autowired
	private ClienteService clieServ;
	
	@Transactional
	public Entrega solicitar(Entrega entrega) {
		entrega.setCliente(clieServ.getCliente(entrega.getCliente().getId()));
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime.now());
		
		return repo.save(entrega);
	}
}
