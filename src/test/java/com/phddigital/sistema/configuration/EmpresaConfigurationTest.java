package com.phddigital.sistema.configuration;

import com.phddigital.sistema.model.Empresa;
import com.phddigital.sistema.model.datas.Telefone;
import com.phddigital.sistema.model.datas.endereco.Endereco;
import com.phddigital.sistema.service.EmpresaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmpresaConfigurationTest {
@Autowired
@Qualifier("idEmpresa")
private Optional<Integer> id;
@Autowired
EmpresaService service;
    @Test
    void getIdEmpresa() {
        Empresa em = new Empresa();
        Telefone t = new Telefone();
        Endereco e = new Endereco();
        em.setId(1);
        t.setId(1);
        e.setId(1);

        em.setTelefone(t);
        em.setEndereco(e);
        service.cadastrar(em);
        if(id.isPresent()){
            System.out.println("id da empresa "+id.get());
        }
       System.out.println("não foi cadastrado nenhuma");
    }

    @Test
    void getEmpresa() {
    }
}