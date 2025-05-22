package com.example.controle_estoque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controle_estoque.model.UsuarioModel;
import com.example.controle_estoque.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public List<UsuarioModel> listarTodos(){
        return repository.findAll();    
    }

    public Optional<UsuarioModel> buscarId(Integer id){
        return repository.findById(id);
    }

    public UsuarioModel salvar(UsuarioModel usuarioModal){
        return repository.save(usuarioModal);
    }

    public void deletar(Integer id){
        repository.deleteById(id);
    }
}