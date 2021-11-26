package silveira.caio.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import silveira.caio.api.model.EntregaResponse;
import silveira.caio.api.model.input.EntregaInput;
import silveira.caio.domain.model.Entrega;

@AllArgsConstructor
@Component
public class EntregaMapper {

	
	private ModelMapper mapper;
	
	public EntregaResponse toResponse(Entrega entrega) {
		return mapper.map(entrega, EntregaResponse.class);
	}
	
	public List<EntregaResponse> toCollectionResponse(List<Entrega> entregas){
		return entregas.stream().map(this::toResponse).collect(Collectors.toList());
	}
	
	public Entrega toEntity(EntregaInput input) {
		return mapper.map(input, Entrega.class);
	}
	
}
