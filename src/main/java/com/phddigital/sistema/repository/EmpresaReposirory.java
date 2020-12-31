package com.phddigital.sistema.repository;

import com.phddigital.sistema.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmpresaReposirory extends JpaRepository<Empresa,Integer> {
    @Query(value = "Select ID from empresa Order by ID Limit 1 ", nativeQuery = true)
    public Integer getId();
    @Query(value = "Select * from empresa Order by ID Limit 1 ",nativeQuery = true)
    public Empresa getEmpresa();
}
