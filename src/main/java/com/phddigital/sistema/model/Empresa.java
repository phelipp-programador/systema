package com.phddigital.sistema.model;

import com.phddigital.sistema.model.datas.Endereco;
import com.phddigital.sistema.model.datas.Telefone;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Empresa implements ObjectModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id ;
    private String nome;
    @OneToOne(cascade = CascadeType.MERGE)
    private Endereco endereco;
    @OneToOne(cascade = CascadeType.MERGE)
    private Telefone telefone;
    private String cnpj;
    private String inscricaoEstadual;
}
