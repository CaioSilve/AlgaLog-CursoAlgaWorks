package silveira.caio.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import silveira.caio.api.mapper.EntregaMapper;
import silveira.caio.api.model.EntregaResponse;
import silveira.caio.api.model.input.EntregaInput;
import silveira.caio.domain.repository.EntregaRepository;
import silveira.caio.domain.service.EntregaService;
import silveira.caio.domain.service.FinzalizarService;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

	@Autowired
	private EntregaService serv;
	
	@Autowired
	private EntregaRepository repo;
	
	@Autowired
	private EntregaMapper mapper;
	
	@Autowired
	private FinzalizarService finalizar;
	
	@GetMapping
	public List<EntregaResponse> getEntregas(){
		return mapper.toCollectionResponse(repo.findAll());
	}
	
	@GetMapping("/{entregaId}")
	public ResponseEntity<EntregaResponse> getEntrega(@PathVariable("entregaId") Long id){
		return repo.findById(id).map(entrega -> ResponseEntity.ok(mapper.toResponse(entrega)))
				.orElse(ResponseEntity.notFound().build()); 
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EntregaResponse solicitar(@Valid @RequestBody EntregaInput input) {
		return mapper.toResponse(serv.solicitar(mapper.toEntity(input)));
	}
	
	@PutMapping("/{id}/finalizacao")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void finalizar(@PathVariable Long id) {
		finalizar.finalizar(id);
	}
	
	
	
	
	
	
	
	
	
	
	
}
