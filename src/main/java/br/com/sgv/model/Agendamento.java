
package br.com.sgv.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToMany
    private Servico servico;
    @OneToMany
    private Cliente cliente;
    @OneToMany
    private Barbeiro barbeiro;
    @Override
    public String toString(){
        return "Servico: " + servico + " " + "Cliente: " + cliente + " " + "Barbeiro: " + barbeiro;
    }
}
