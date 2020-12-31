package com.phddigital.sistema.model.datas.endereco;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    private Estado estado;
    private String nome;
}
