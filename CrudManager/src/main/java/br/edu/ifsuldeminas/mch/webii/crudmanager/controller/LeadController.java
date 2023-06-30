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

import br.edu.ifsuldeminas.mch.webii.crudmanager.dao.LeadRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.dao.VendedorRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Lead;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Vendedor;

@Controller
public class LeadController {

    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private VendedorRepository vendedorRepository;

    // Métodos para CRUD (create, read, update, delete) do Lead

    @GetMapping("/leads")
    public String listarLeads(Model model) {
        List<Lead> leads = leadRepository.findAll();
        model.addAttribute("leads", leads);
        return "leads";
    }

    @GetMapping("/leads/form")
    public String exibirFormularioLead(@ModelAttribute("lead") Lead lead, Model model) {
    	List<Vendedor> vendedores = vendedorRepository.findAll();
        model.addAttribute("vendedores", vendedores);
        return "lead_form";
    }

    @PostMapping("/leads/new")
    public String salvarLead(@Valid @ModelAttribute("lead") Lead lead, BindingResult bindingResult,  Model model) {
        if (bindingResult.hasErrors())
        {
        	List<Vendedor> vendedores = vendedorRepository.findAll();
            model.addAttribute("vendedores", vendedores);
            return "lead_form";
        }

        Integer vendedorId = lead.getVendedor().getId();
        Vendedor vendedor = null;

        if (vendedorId != null) {
            vendedor = vendedorRepository.findById(vendedorId).orElse(null);
        }

        lead.setVendedor(vendedor);
        leadRepository.save(lead);
        return "redirect:/leads";
    }
    

    @GetMapping("/leads/update/{id}")
    public String editarLead(@PathVariable("id") Integer id, Model model) {
        Optional<Lead> optLead = leadRepository.findById(id);
        if (!optLead.isPresent()) {
            // Gerar erro
        }

        Lead lead = optLead.get();
        List<Vendedor> vendedores = vendedorRepository.findAll();

        model.addAttribute("lead", lead);
        model.addAttribute("vendedores", vendedores);

        return "lead_form";
    }

    @GetMapping("/leads/delete/{id}")
    public String excluirLead(@PathVariable("id") Integer id) {
        Optional<Lead> optLead = leadRepository.findById(id);
        if (!optLead.isPresent()) {
            // Gerar erro
        }

        Lead lead = optLead.get();
        leadRepository.delete(lead);

        return "redirect:/leads";
    }
}
