
package br.com.sgv.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cliente extends Pessoa  {
    
    @Size(min=8,message = "O número de telefone precisa ser válido.")
    private String telefone;
    @Override
    public String toString(){
        return telefone;
    }
}
