package silveira.caio.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import silveira.caio.domain.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
