
package br.com.sgv.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Size(min=1,message = "Declare o tipo de servico.")
    private String servico;
    @Size(min=1,message = "Declare o valor do servico.")
    private float valor;
    @Override
    public String toString(){
        return "Servico: " + servico + ' ' + "Valor: " + valor;
    }
}
