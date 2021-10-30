package silveira.caio.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import silveira.caio.domain.model.Cliente;
import silveira.caio.domain.repository.ClienteRepository;
import silveira.caio.domain.service.ClienteService;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	ClienteRepository repo;
	
	@Autowired
	ClienteService serv;
	
	
	@GetMapping
	public List<Cliente> getClientes() {
		return repo.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getCliente(@PathVariable(name = "id") Long clieId){
		return repo.findById(clieId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
//		OU
//		Cliente clie = repo.findById(clieId).orElse(null);
//		
//		return clie != null ?  ResponseEntity.ok(clie) : ResponseEntity.notFound().build();	
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente salvarCliente(@Valid @RequestBody Cliente clie){
		return serv.salvar(clie);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> alterarCliente(@PathVariable Long id, @Valid @RequestBody Cliente clie) {
		
		if(!repo.existsById(id)) return ResponseEntity.notFound().build();

		clie.setId(id);
		serv.salvar(clie);
		
		return ResponseEntity.ok(clie);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> removerCliente(@PathVariable Long id){
		if(!repo.existsById(id)) return ResponseEntity.notFound().build();
		
		serv.remover(id);
		
		return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	
	
	
	
	
}
