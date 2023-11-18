package br.com.sgv.controller;

import br.com.sgv.model.Agendamento;
import br.com.sgv.repository.BarbeiroRepository;
import br.com.sgv.repository.ClienteRepository;
import br.com.sgv.repository.ServicoRepository;
import br.com.sgv.repository.AgendamentoRepository;
import jakarta.validation.Valid;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AgendamentoController {

    @Autowired
    private AgendamentoRepository agendamentoRepository;
    @Autowired
    private BarbeiroRepository barbeiroRepository;
    private ClienteRepository clienteRepository;
    private ServicoRepository servicoRepository;
    private Agendamento agendamento;

    @GetMapping("/agendamentos")
    public String listarAgendamentos(Model model) {
        model.addAttribute("listaAgendamentos", agendamentoRepository.findAll());
        return "gerenciar_agendamentos";
    }

    @GetMapping("/agendamentos/novo")
    public String novo(Model model) {
        agendamento = new Agendamento();
        agendamentoRepository.save(agendamento);
        model.addAttribute("listaBarbeiros", barbeiroRepository.findAll());
        model.addAttribute("listaClientes", clienteRepository.findAll());
        model.addAttribute("listaServicos", servicoRepository.findAll());
        model.addAttribute("agendamento", agendamento);
        return "editar_agendamento";
    }

    @GetMapping("/agendamentos/{id}")
    public String editar(@PathVariable("id") long idAgendamento, Model model) {
        Optional<Agendamento> busca = agendamentoRepository.findById(idAgendamento);
        agendamento = busca.get();
        model.addAttribute("agendamento", agendamento);
        model.addAttribute("listaBarbeiros", barbeiroRepository.findAll());
        model.addAttribute("listaClientes", clienteRepository.findAll());
        model.addAttribute("listaServicos", servicoRepository.findAll());
        return "editar_agendamento";
    }

    @PostMapping("/agendamentos")
    public String salvar(@Valid Agendamento agendamento, BindingResult result) {
        if (result.hasErrors()) {
            return "editar_agendamento";
        }
        this.agendamento.setDataAgendamento(agendamento.getDataAgendamento());
        agendamentoRepository.save(this.agendamento);
        return "redirect:/agendamentos";
    }
    
    @DeleteMapping("/agendamentos/{id}")
    public String excluir(@PathVariable("id") long id) {
        agendamentoRepository.deleteById(id);
        return "redirect:/agendamentos";
    }
}
