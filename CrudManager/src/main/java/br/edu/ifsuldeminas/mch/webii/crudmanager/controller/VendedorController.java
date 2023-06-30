package br.edu.ifsuldeminas.mch.webii.crudmanager.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifsuldeminas.mch.webii.crudmanager.dao.VendedorRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Vendedor;

@Controller
public class VendedorController {
    
    @Autowired
    private VendedorRepository vendedorRepository;
    
    // Métodos para CRUD (create, read, update, delete) do Vendedor
    
    @GetMapping("/vendedores")
    public String listarVendedores(Model model) {
        List<Vendedor> vendedores = vendedorRepository.findAll();
        model.addAttribute("vendedores", vendedores);
        return "vendedores";
    }

    @GetMapping("/vendedores/form")
    public String exibirFormularioVendedor(@ModelAttribute("vendedor") Vendedor vendedor) {
        return "vendedor_form";
    }

    @PostMapping("/vendedores/salvar")
    public String salvarVendedor(@Valid @ModelAttribute("vendedor") Vendedor vendedor, BindingResult bindingResult) {
    	if(bindingResult.hasErrors())
		{
			return "vendedor_form";
		}
    	
    	vendedorRepository.save(vendedor);
        return "redirect:/vendedores";
    }

    @GetMapping("/vendedores/editar/{id}")
    public String editarVendedor(@PathVariable("id") Integer id, Model model) {
        Optional<Vendedor> optVendedor = vendedorRepository.findById(id);
        if (!optVendedor.isPresent()) {
            // Gerar erro
        }
        
        Vendedor vendedor = optVendedor.get();
        model.addAttribute("vendedor", vendedor);
        
        return "vendedor_form";
    }

    @GetMapping("/vendedores/excluir/{id}")
    public String excluirVendedor(@PathVariable("id") Integer id) {
        Optional<Vendedor> optVendedor = vendedorRepository.findById(id);
        if (!optVendedor.isPresent()) {
            // Gerar erro
        }
        
        Vendedor vendedor = optVendedor.get();
        vendedorRepository.delete(vendedor);
        
        return "redirect:/vendedores";
    }
}