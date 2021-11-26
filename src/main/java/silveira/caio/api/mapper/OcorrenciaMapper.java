package silveira.caio.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import silveira.caio.api.model.OcorrenciaResponse;
import silveira.caio.domain.model.Ocorrencia;

@Component
public class OcorrenciaMapper {

	@Autowired
	private ModelMapper mapper;
	
	public OcorrenciaResponse toResponse(Ocorrencia oco) {
		return mapper.map(oco, OcorrenciaResponse.class);
	}
	
	public List<OcorrenciaResponse> toCollectionModel(List<Ocorrencia> lista){
		return lista.stream().map(this::toResponse).collect(Collectors.toList());
	}
}
