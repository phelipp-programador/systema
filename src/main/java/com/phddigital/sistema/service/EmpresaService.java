package com.phddigital.sistema.service;

import com.phddigital.sistema.model.Empresa;
import com.phddigital.sistema.repository.EmpresaReposirory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService implements ServiceCadastro {
    @Autowired
    private final EmpresaReposirory reposirory;
    private static Empresa empresa;
    private boolean cadastrado = false;

    public EmpresaService(EmpresaReposirory reposirory) {
        this.reposirory = reposirory;
    }

    public void cadastrar(Empresa entity) {
        if (empresa != null) {
            entity.setId(empresa.getId());
            entity.setTelefone(empresa.getTelefone());
            entity.setEndereco(empresa.getEndereco());
        }
        Optional<Empresa> save = save(reposirory, entity);
        empresa = save.get();

    }

    public void atualizarDados(Empresa entity) {
        entity.getTelefone().setId(empresa.getTelefone().getId());
        entity.getEndereco().setId(empresa.getEndereco().getId());
        Optional update = update(reposirory, empresa.getId(), entity);
        if (update.isEmpty()) {
            cadastrar(entity);
        }

    }

    public Empresa selectDados() {
        Optional<List> select = select(reposirory);

        if(select.isPresent()){
            this.empresa = (Empresa) select.get().get(0);
            return this.empresa;
        }
        else{
           throw  new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

    }
}
