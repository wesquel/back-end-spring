package br.com.api.projetos.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.projetos.api.models.Cliente;
import br.com.api.projetos.api.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class clienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente cadastrar(@RequestBody Cliente cliente){
        System.out.println(cliente);
        return clienteRepository.save(cliente);
    }

}
