package com.example.dev.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dev.domain.Categoria;
import com.example.dev.repositories.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria find(Integer id) { 
        Optional<Categoria> obj = repo.findById(id); 
       return obj.orElse(null); 
       }

}
