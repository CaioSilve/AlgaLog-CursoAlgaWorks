package silveira.caio.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import silveira.caio.domain.model.Cliente;
import silveira.caio.domain.repository.ClienteRepository;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	ClienteRepository repo;
	
	
	@GetMapping
	public List<Cliente> getClientes() {
		return repo.findAll();
	}
}
