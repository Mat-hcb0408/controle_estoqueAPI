package com.example.controle_estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.controle_estoque.model.UsuarioModel;

@Repository

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer>{}