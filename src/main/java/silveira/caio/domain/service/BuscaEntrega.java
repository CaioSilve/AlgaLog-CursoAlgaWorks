package silveira.caio.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import silveira.caio.domain.exception.EntidadeNFException;
import silveira.caio.domain.model.Entrega;
import silveira.caio.domain.repository.EntregaRepository;

@Service
public class BuscaEntrega {

	@Autowired
	private EntregaRepository repoEntr;
	
	public Entrega busca(Long entregaId) {
		return repoEntr.findById(entregaId).orElseThrow(() -> new EntidadeNFException("Entrega não encontrada"));
	}
}
