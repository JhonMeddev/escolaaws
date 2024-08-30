package com.escolaaws.repository;

import com.escolaaws.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository <Aluno, Long>{
    public List<Aluno> findAllByNomeContainingIgnoreCase(String nomeAluno);
}
