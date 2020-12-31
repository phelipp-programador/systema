package com.phddigital.sistema.controller;

import com.phddigital.sistema.model.Empresa;
import com.phddigital.sistema.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    private final EmpresaService service;
    @Autowired
    public ClienteController(EmpresaService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrar(@RequestBody Empresa entity){
        service.cadastrar(entity);
    }
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void atualizar(@RequestBody Empresa entity){
        service.atualizarDados(entity);
    }
    @GetMapping
    public Empresa selectDados(){
        return service.selectDados();
    }
    
}
