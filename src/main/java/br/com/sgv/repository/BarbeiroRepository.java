package br.com.sgv.repository;


import br.com.sgv.model.Barbeiro;
import org.springframework.data.repository.CrudRepository;

public interface BarbeiroRepository extends CrudRepository<Barbeiro,Long>{
    
}
