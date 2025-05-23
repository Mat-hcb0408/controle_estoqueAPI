package com.example.controle_estoque.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="saida")

@Getter
@Setter
@NoArgsConstructor

public class SaidaModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_saida;

    @Column(nullable=false)
    private LocalDate data_saida;

    @ManyToOne(optional=false)
    @JoinColumn(name="id_usuario",referencedColumnName="id_usuario",foreignKey=@ForeignKey(name="fk_usuario"))
    private UsuarioModel usuario;

    @ManyToOne(optional=false)
    @JoinColumn(name="id_produto",referencedColumnName="id_produto",foreignKey=@ForeignKey(name="fk_produto"))
    private ProdutosModel produto;

    @Column(nullable=false)
    private Integer quantidade_saida;
}
