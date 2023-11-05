package br.com.sgv.repository;

import org.springframework.data.repository.CrudRepository;
import br.com.sgv.model.Agendamento;

public interface AgendamentoRepository extends CrudRepository<Agendamento,Long>{
    
}
