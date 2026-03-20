package com.bn.gerenciamentodeautorescs.controllers;

import com.bn.gerenciamentodeautorescs.models.AutorModel;
import com.bn.gerenciamentodeautorescs.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping
    public ResponseEntity<AutorModel> salvar(@RequestBody AutorModel autorModel) {
        AutorModel request = autorService.criar(autorModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/autores/{id}").buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<AutorModel>> listar() {
        List<AutorModel> request = autorService.listar();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorModel> procurarPorId(@PathVariable Long id) {
        AutorModel request = autorService.procurarPorId(id);
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        autorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
