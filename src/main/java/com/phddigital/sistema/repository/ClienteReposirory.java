package com.phddigital.sistema.repository;

import com.phddigital.sistema.model.Empresa;
import com.phddigital.sistema.model.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteReposirory extends JpaRepository<Cliente,Integer> {
    @Query(value = "Select * From cliente where UPPER(nome) LIKE UPPER(CONCAT(:nome,'%'))",nativeQuery = true)
    List<Cliente> clientByName(@Param("nome") String nome);
}
