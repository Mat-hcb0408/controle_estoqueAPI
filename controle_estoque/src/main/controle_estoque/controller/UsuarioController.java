package com.example.controle_estoque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controle_estoque.model.UsuarioModel;
import com.example.controle_estoque.services.UsuarioService;


@RestController
@RequestMapping("api/Usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<UsuarioModel> listarTodos(){
    return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> buscarId(@PathVariable Integer id){
        return service.buscarId(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public UsuarioModel salvar(@RequestBody UsuarioModel usuarioModel){
        return service.salvar(usuarioModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioModel> atualizar(@PathVariable Integer id, @RequestBody UsuarioModel usuarioModel) {
        if (!service.buscarId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        usuarioModel.setId_usuario(id);

        return ResponseEntity.ok(service.salvar(usuarioModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        if(!service.buscarId(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
