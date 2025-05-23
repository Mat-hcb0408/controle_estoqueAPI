package com.example.controle_estoque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.controle_estoque.model.ProdutosModel;
import com.example.controle_estoque.services.ProdutoService;

@RestController
@RequestMapping("api/Produtos")
public class ProdutosController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<ProdutosModel> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutosModel> buscarId(@PathVariable Integer id) {
        return service.buscarId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProdutosModel salvar(@RequestBody ProdutosModel produtoModel) {
        return service.salvar(produtoModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutosModel> atualizar(@PathVariable Integer id, @RequestBody ProdutosModel produtoModel) {
        if (!service.buscarId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        produtoModel.setId_produto(id);
        return ResponseEntity.ok(service.salvar(produtoModel));
    }
}