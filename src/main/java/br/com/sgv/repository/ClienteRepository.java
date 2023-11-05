package br.com.sgv.repository;

import org.springframework.data.repository.CrudRepository;
import br.com.sgv.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente,Long>{
    
}
