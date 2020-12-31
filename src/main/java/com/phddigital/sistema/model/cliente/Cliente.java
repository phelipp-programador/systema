package com.phddigital.sistema.model.cliente;

import com.phddigital.sistema.model.datas.Telefone;
import com.phddigital.sistema.model.datas.endereco.Endereco;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private String cpf;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Endereco endereco;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Telefone telefone;
}
