package br.edu.ifsuldeminas.mch.webii.crudmanager;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifsuldeminas.mch.webii.crudmanager.dao.UserRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.dao.VendedorRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.dao.LeadRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.User;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Vendedor;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Lead;

@Component
@Transactional
public class InitializeDataBase implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private LeadRepository leadRepository;

    @Override
    public void run(String... args) throws Exception {
        User emerson = new User();
        emerson.setName("Emerson");
        emerson.setEmail("emerson@gmail.com");
        emerson.setGender("M");

        User luiza = new User();
        luiza.setName("Luiza");
        luiza.setEmail("luiza@gmail.com");
        luiza.setGender("F");

        User renaki = new User();
        renaki.setName("Renaki");
        renaki.setEmail("renaki@gmail.com");
        renaki.setGender("M");

        userRepository.save(emerson);
        userRepository.save(luiza);
        userRepository.save(renaki);

        Vendedor vendedor1 = new Vendedor();
        vendedor1.setNome("João");
        vendedor1.setEmail("joao@gmail.com");
        vendedor1.setTelefone("123456789");
        vendedor1.setMeta(5000.0); // Definindo a meta

        Vendedor vendedor2 = new Vendedor();
        vendedor2.setNome("Maria");
        vendedor2.setEmail("maria@gmail.com");
        vendedor2.setTelefone("987654321");
        vendedor2.setMeta(7000.0); // Definindo a meta
        
        Vendedor vendedor3 = new Vendedor();
        vendedor3.setNome("Roberto");
        vendedor3.setEmail("Roberto@gmail.com");
        vendedor3.setTelefone("53456765");
        vendedor3.setMeta(6000.0); // Definindo a meta
        
        Vendedor vendedor4 = new Vendedor();
        vendedor4.setNome("DiCaprio");
        vendedor4.setEmail("LobodeWallsStreet@gmail.com");
        vendedor4.setTelefone("98457395032");
        vendedor4.setMeta(715000.0); // Definindo a meta
        
        Vendedor vendedor5 = new Vendedor();
        vendedor5.setNome("Mateus");
        vendedor5.setEmail("Mateus@gmail.com");
        vendedor5.setTelefone("658343243");
        vendedor5.setMeta(3500.0); // Definindo a meta
        
        Vendedor vendedor6 = new Vendedor();
        vendedor6.setNome("Luciana");
        vendedor6.setEmail("Luciana@gmail.com");
        vendedor6.setTelefone("98732431");
        vendedor6.setMeta(5000.0); // Definindo a meta
        
        Vendedor vendedor7 = new Vendedor();
        vendedor7.setNome("Lucas");
        vendedor7.setEmail("Lucas@gmail.com");
        vendedor7.setTelefone("56794356");
        vendedor7.setMeta(10000.0); // Definindo a meta
        
        Vendedor vendedor8 = new Vendedor();
        vendedor8.setNome("Bruna");
        vendedor8.setEmail("Bruna@gmail.com");
        vendedor8.setTelefone("23487668");
        vendedor8.setMeta(3000.0); // Definindo a meta

        vendedorRepository.save(vendedor1);
        vendedorRepository.save(vendedor2);
        vendedorRepository.save(vendedor3);
        vendedorRepository.save(vendedor4);
        vendedorRepository.save(vendedor5);
        vendedorRepository.save(vendedor6);
        vendedorRepository.save(vendedor7);
        vendedorRepository.save(vendedor8);

        Lead lead1 = new Lead();
        lead1.setNome("João Silva");
        lead1.setEmail("joao.silva@gmail.com");
        lead1.setVendedor(vendedor1);
        lead1.setTelefone("35977452");
        lead1.setAtivo(true); // Definindo o status ativo

        Lead lead2 = new Lead();
        lead2.setNome("Maria Santos");
        lead2.setEmail("maria.santos@gmail.com");
        lead2.setVendedor(vendedor2);
        lead2.setTelefone("35977454");
        lead2.setAtivo(false); // Definindo o status inativo

        Lead lead3 = new Lead();
        lead3.setNome("Carlos Almeida");
        lead3.setEmail("carlos.almeida@gmail.com");
        lead3.setVendedor(vendedor3);
        lead3.setTelefone("35977456");
        lead3.setAtivo(true);

        Lead lead4 = new Lead();
        lead4.setNome("Ana Pereira");
        lead4.setEmail("ana.pereira@gmail.com");
        lead4.setVendedor(vendedor4);
        lead4.setTelefone("35977458");
        lead4.setAtivo(true);

        Lead lead5 = new Lead();
        lead5.setNome("Pedro Oliveira");
        lead5.setEmail("pedro.oliveira@gmail.com");
        lead5.setVendedor(vendedor5);
        lead5.setTelefone("35977460");
        lead5.setAtivo(false);

        Lead lead6 = new Lead();
        lead6.setNome("Mariana Costa");
        lead6.setEmail("mariana.costa@gmail.com");
        lead6.setVendedor(vendedor6);
        lead6.setTelefone("35977462");
        lead6.setAtivo(true);

        Lead lead7 = new Lead();
        lead7.setNome("Fernando Santos");
        lead7.setEmail("fernando.santos@gmail.com");
        lead7.setVendedor(vendedor7);
        lead7.setTelefone("35977464");
        lead7.setAtivo(true);

        Lead lead8 = new Lead();
        lead8.setNome("Juliana Oliveira");
        lead8.setEmail("juliana.oliveira@gmail.com");
        lead8.setVendedor(vendedor8);
        lead8.setTelefone("35977466");
        lead8.setAtivo(false);

        leadRepository.save(lead1);
        leadRepository.save(lead2);
        leadRepository.save(lead3);
        leadRepository.save(lead4);
        leadRepository.save(lead5);
        leadRepository.save(lead6);
        leadRepository.save(lead7);
        leadRepository.save(lead8);
    }
}