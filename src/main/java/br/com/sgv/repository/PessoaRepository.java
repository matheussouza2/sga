package br.com.sgv.repository;

import br.com.sgv.model.Pessoa;
import org.springframework.data.repository.CrudRepository;

public interface PessoaRepository extends CrudRepository<Pessoa,Long>{
    
}
