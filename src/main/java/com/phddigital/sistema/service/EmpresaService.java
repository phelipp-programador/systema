package com.phddigital.sistema.service;

import com.phddigital.sistema.model.Empresa;
import com.phddigital.sistema.repository.EmpresaReposirory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService implements ServiceCadastro {

    private final EmpresaReposirory reposirory;
    private boolean cadastrado = false;
    @Autowired
    @Qualifier("idEmpresa")
    private Optional<Integer> idEmpresa;
    @Autowired
    @Qualifier("empresa")
    private Optional<Empresa> empresa;
    @Autowired
    public EmpresaService(EmpresaReposirory reposirory) {
        this.reposirory = reposirory;
    }

    public void cadastrar(Empresa entity) {
        if(empresa.isPresent()){
            entity.setId(empresa.get().getId());
            entity.setTelefone(empresa.get().getTelefone());
            entity.setEndereco(empresa.get().getEndereco());
        }

        empresa = save(reposirory, entity);


    }

    public void atualizarDados(Empresa entity) {
        if(empresa.isPresent()){
            entity.getTelefone().setId(empresa.get().getTelefone().getId());
            entity.getEndereco().setId(empresa.get().getEndereco().getId());
            update(reposirory, empresa.get().getId(), entity);
        }else{
            cadastrar(entity);
        }


    }

    public Empresa selectDados() {
        Optional<List> select = select(reposirory);

        if(select.isPresent()){
            this.empresa = Optional.of((Empresa) select.get().get(0));
            return this.empresa.get();
        }
        else{
           throw  new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

    }
}
