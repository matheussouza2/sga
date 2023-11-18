package br.com.sgv.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Agendamento implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    @OneToOne
    private Barbeiro barbeiro;
    @OneToOne
    private Cliente cliente;
    @OneToOne
    private Servico servico;
    private Date dataAgendamento = new Date();

    public String getDataAgendamentoFormatada() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(dataAgendamento);
    }
    
    public String getDataAgendamento() {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        return formato.format(dataAgendamento);
    }

    public void setDataAgendamento(String dataAgendamento) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
        Date data = null;
        try {
            data = formato.parse(dataAgendamento);
        } catch (ParseException ex) {
            Logger.getLogger(Agendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dataAgendamento = data;
    }
    public Agendamento(){
        barbeiro = new Barbeiro();
        cliente = new Cliente();
        servico = new Servico();
    }@Override
    public String toString(){
        return "Servico: " + servico.getDescricao() + ' ' + barbeiro.getNome() + ' ' + cliente.getNome() + ' ' + dataAgendamento;
    }
    
}
