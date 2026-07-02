package com.poo.bibliteca_cadastro_app.controller;

import com.poo.bibliteca_cadastro_app.model.Usuario;
import com.poo.bibliteca_cadastro_app.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("usuarios", service.listarTodos());
        return "usuarios";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "cadastrar-usuario";
    }

    @PostMapping("/salvar")
    public String salvar(
            @Valid Usuario usuario,
            BindingResult result) {

        if(result.hasErrors()) {
            return "cadastrar-usuario";
        }

        service.salvar(usuario);

        return "redirect:/usuarios";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {

        service.excluir(id);

        return "redirect:/usuarios";
    }
}