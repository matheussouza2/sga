package br.com.sgv.controller;

import br.com.sgv.model.Barbeiro;
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
import br.com.sgv.repository.BarbeiroRepository;

@Controller
public class BarbeiroController {

    @Autowired
    private BarbeiroRepository barbeiroRepository;

    @GetMapping("/barbeiros")
    public String listar(Model model) {
        model.addAttribute("listaBarbeiros", barbeiroRepository.findAll());
        return "gerenciar_barbeiros";
    }

    @GetMapping("/barbeiros/novo")
    public String novo(Model model) {
        model.addAttribute("barbeiro", new Barbeiro());
        return "editar_barbeiro";
    }

    @GetMapping("/barbeiros/{id}")
    public String editar(@PathVariable("id") long id, Model model) {
        Optional<Barbeiro> barbeiro = barbeiroRepository.findById(id);
        model.addAttribute("barbeiro", barbeiro.get());
        return "editar_barbeiro";
    }

    @PostMapping("/barbeiros")
    public String salvar(@Valid Barbeiro barbeiro, BindingResult result) {
        if (result.hasErrors()) {
            return "editar_barbeiro";
        }
        barbeiroRepository.save(barbeiro);
        return "redirect:/barbeiros";
    }

    @DeleteMapping("/barbeiros/{id}")
    public String excluir(@PathVariable("id") long id) {
        barbeiroRepository.deleteById(id);
        return "redirect:/barbeiros";
    }
}
