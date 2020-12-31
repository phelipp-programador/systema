package com.phddigital.sistema.configuration;

import com.phddigital.sistema.model.Empresa;
import com.phddigital.sistema.repository.EmpresaReposirory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class EmpresaConfiguration {
    @Autowired
    private EmpresaReposirory repository;

    private Empresa empresa;

    @Bean(name = "idEmpresa")
    public Optional<Integer> getIdEmpresa() {
        Integer idEmpresa = repository.getId();
        if(idEmpresa !=null){
           return Optional.of(idEmpresa);
        }else{
            return Optional.empty();
        }


    }
    @Bean(name="empresa")
    public Optional<Empresa> getEmpresa(){
        if(empresa==null){
            empresa = repository.getEmpresa();
        }
        return (empresa == null)?Optional.empty():Optional.of(empresa);
    }
}
