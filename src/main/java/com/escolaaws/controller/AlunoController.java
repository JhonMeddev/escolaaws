package com.escolaaws.controller;


import com.escolaaws.model.Aluno;
import com.escolaaws.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public ResponseEntity<List<Aluno>> getAll(){
        return ResponseEntity.ok(alunoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getById(@PathVariable long id){
        return alunoRepository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Aluno>> getAlunoByName(@PathVariable String name){
        return  ResponseEntity.ok(alunoRepository.findAllByNomeContainingIgnoreCase(name));
    }

    @PostMapping
    public ResponseEntity<Aluno> postAluno(@RequestBody Aluno aluno){
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoRepository.save(aluno));
    }

    @PutMapping
    public ResponseEntity<Aluno> putAluno(@RequestBody Aluno aluno){
        return alunoRepository.findById(aluno.getId())
                .map(resp -> ResponseEntity.ok().body(alunoRepository.save(aluno)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAluno(@PathVariable long id){
        return alunoRepository.findById(id)
                .map(resp -> {
                    alunoRepository.deleteById(id);
                    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

