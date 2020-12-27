package com.phddigital.sistema.service;

import com.phddigital.sistema.model.ObjectModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ServiceCadastro {
    default Optional save(JpaRepository repository, ObjectModel entity){
        ObjectModel save = (ObjectModel) repository.save(entity);
        return (save!=null)?Optional.of(save) : Optional.empty();
    }
    default Optional update (JpaRepository repository, Integer id,ObjectModel entity){
        return repository.findById(id).map(e -> {
            entity.setId(id);
            repository.save(entity);
            return e;
        });
    }
    default Optional<List> select(JpaRepository repository){
        List all = repository.findAll();
        return (all.size()>0)?Optional.of(all):Optional.empty();
    }
    default Optional select(JpaRepository repository,Integer id){
        return repository.findById(id);
    }

}
