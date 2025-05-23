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

import com.example.controle_estoque.model.SaidaModel;
import com.example.controle_estoque.services.SaidaService;

@RestController
@RequestMapping("/api/saida")
public class SaidaController {
    @Autowired
    private SaidaService service;

    @GetMapping
    public List<SaidaModel>listarTodos() {
        return service.listarTodos();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<SaidaModel> buscarId(@PathVariable Integer id){
        return service.buscarId(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}")
    public SaidaModel salvar(@RequestBody SaidaModel saidaModel){
        return service.salvar(saidaModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaidaModel> deletar(@PathVariable Integer id, @RequestBody SaidaModel saidaModel){
        if(!service.buscarId(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        saidaModel.setId_saida(id);
        return ResponseEntity.ok(service.salvar(saidaModel));
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
