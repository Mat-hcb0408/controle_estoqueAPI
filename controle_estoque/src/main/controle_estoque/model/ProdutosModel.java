package com.example.controle_estoque.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="produtos")

@Getter
@Setter
@NoArgsConstructor

public class ProdutosModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id_produto;

    @Column(nullable=false)
    private String nome;
    
    @Column(nullable=false)
    private Integer quantidade;

    @Column(nullable=false)
    private String status_produto;
}
