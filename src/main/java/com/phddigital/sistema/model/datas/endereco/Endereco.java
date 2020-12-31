package com.phddigital.sistema.model.datas.endereco;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id ;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    @ManyToOne
    private Estado estado;
    private String cep;

}
