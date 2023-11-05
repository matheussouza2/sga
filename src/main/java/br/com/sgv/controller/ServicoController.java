package br.com.sgv.controller;

import br.com.sgv.model.Servico;
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
import br.com.sgv.repository.ServicoRepository;

@Controller
public class ServicoController {

    @Autowired
    private ServicoRepository servicoRepository;

    @GetMapping("/servicos")
    public String listar(Model model) {
        model.addAttribute("listaServicos", servicoRepository.findAll());
        return "gerenciar_servicos";
    }

    @GetMapping("/servicos/novo")
    public String novo(Model model) {
        model.addAttribute("servico", new Servico());
        return "editar_servicos";
    }

    @GetMapping("/servicos/{id}")
    public String editar(@PathVariable("id") long id, Model model) {
        Optional<Servico> servico = servicoRepository.findById(id);
        model.addAttribute("servico", servico.get());
        return "editar_servicos";
    }

    @PostMapping("/servicos")
    public String salvar(@Valid Servico servico, BindingResult result) {
        if (result.hasErrors()) {
            return "editar_servicos";
        }
        servicoRepository.save(servico);
        return "redirect:/servicos";
    }

    @DeleteMapping("/servicos/{id}")
    public String excluir(@PathVariable("id") long id) {
        servicoRepository.deleteById(id);
        return "redirect:/servicos";
    }
}
