package silveira.caio.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import silveira.caio.api.mapper.OcorrenciaMapper;
import silveira.caio.api.model.OcorrenciaResponse;
import silveira.caio.api.model.input.OcorrenciaInput;
import silveira.caio.domain.model.Entrega;
import silveira.caio.domain.model.Ocorrencia;
import silveira.caio.domain.service.BuscaEntrega;
import silveira.caio.domain.service.OcorrenciaService;

@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {
	
	@Autowired
	private BuscaEntrega buscaEntrega;
	
	@Autowired
	private OcorrenciaService serv;
	
	@Autowired
	private OcorrenciaMapper mapper;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OcorrenciaResponse registrar(@PathVariable Long entregaId, @Valid @RequestBody OcorrenciaInput ocorrencia) {
		Ocorrencia oco = serv.registrar(entregaId, ocorrencia.getDescricao());
		
		return mapper.toResponse(oco);
	}
	
	@GetMapping
	public List<OcorrenciaResponse> listar(@PathVariable Long entregaId){
		Entrega entr = buscaEntrega.busca(entregaId);
		
		return mapper.toCollectionModel(entr.getOcorrencias());
	}
	
	
	
	
	
	
	
	
}
