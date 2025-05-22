package com.example.controle_estoque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controle_estoque.model.SaidaModel;
//import com.example.controle_estoque.repository.ProdutosRepository;
import com.example.controle_estoque.repository.SaidaRepository;
//import com.example.controle_estoque.repository.UsuarioRepository;

@Service
public class SaidaService {
    @Autowired 
    private SaidaRepository repository;
    //private ProdutosRepository produtosRepository;
    //private UsuarioRepository usuarioRepository;

    public List<SaidaModel> listarTodos(){
        return repository.findAll();
    }

    public Optional<SaidaModel>buscarId(Integer id){
        return repository.findById(id);
    }

    public SaidaModel salvar(SaidaModel saidaModal){
        return repository.save(saidaModal);
    }

    public void deletar(Integer id){
        repository.deleteById(id);
    }
}
