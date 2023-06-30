package br.edu.ifsuldeminas.mch.webii.crudmanager.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "vendedores")
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotBlank(message="Nome não pode ser nulo")
    private String nome;
    @NotBlank(message="E-mail não pode ser nulo")
    private String email;
    @NotBlank(message="Telefone não pode ser nulo")
    private String telefone;
    @NotNull(message="Meta não pode ser nulo")
    private double meta;

    @OneToMany(mappedBy = "vendedor",cascade = CascadeType.REMOVE)
    private List<Lead> leads;

    public Vendedor() {
    }

    public Vendedor(Integer id, String nome, String email, String telefone, double meta) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.meta = meta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public double getMeta() {
        return meta;
    }

    public void setMeta(double meta) {
        this.meta = meta;
    }

    public List<Lead> getLeads() {
        return leads;
    }

    public void setLeads(List<Lead> leads) {
        this.leads = leads;
    }
}