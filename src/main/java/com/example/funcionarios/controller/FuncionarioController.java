package com.example.funcionarios.controller;

import com.example.funcionarios.model.Funcionario;
import com.example.funcionarios.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    // CREATE
    @PostMapping
    public Funcionario criarFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    // READ - listar todos
    @GetMapping
    public List<Funcionario> listarFuncionarios() {
        return funcionarioRepository.findAll();
    }

    // READ - buscar por ID
    @GetMapping("/{id}")
    public Optional<Funcionario> buscarFuncionario(@PathVariable Long id) {
        return funcionarioRepository.findById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Funcionario atualizarFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionarioAtualizado) {
        return funcionarioRepository.findById(id).map(funcionario -> {
            funcionario.setNome(funcionarioAtualizado.getNome());
            funcionario.setCargo(funcionarioAtualizado.getCargo());
            funcionario.setSalario(funcionarioAtualizado.getSalario());
            return funcionarioRepository.save(funcionario);
        }).orElseGet(() -> {
            funcionarioAtualizado.setId(id);
            return funcionarioRepository.save(funcionarioAtualizado);
        });
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deletarFuncionario(@PathVariable Long id) {
        funcionarioRepository.deleteById(id);
    }
}
