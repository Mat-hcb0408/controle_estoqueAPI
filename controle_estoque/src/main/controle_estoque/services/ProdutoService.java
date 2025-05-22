package com.example.controle_estoque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controle_estoque.model.ProdutosModel;
import com.example.controle_estoque.repository.ProdutosRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutosRepository repository;

    public List<ProdutosModel> listarTodos(){
        return repository.findAll();
    }

    public Optional<ProdutosModel> buscarID(Integer id){
        return repository.findById(id);
    }

    public ProdutosModel salvar(ProdutosModel produtosModal) {
        return repository.save(produtosModal);
    }

    public void deletar(Integer id){
        repository.deleteById(id);
    }
}
