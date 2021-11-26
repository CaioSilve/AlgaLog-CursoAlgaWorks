package silveira.caio.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import silveira.caio.domain.model.Entrega;
import silveira.caio.domain.model.Ocorrencia;

@Service
public class OcorrenciaService {

	@Autowired
	private BuscaEntrega buscaEntrega;
	
	@Transactional
	public Ocorrencia registrar(Long entregaId, String descricao) {
		Entrega entre = buscaEntrega.busca(entregaId);
		return entre.addOcorrencia(descricao);
		
	}
}
