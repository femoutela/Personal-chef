package com.novametha.api_personalchef.model;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="receitas")
@Getter 
@Setter 
public class Receita {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "receita_id")
    private List<InsumoQuantidade> insumos;
}