package com.example.controle_estoque.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.controle_estoque.repository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutosRepository repository;
}
