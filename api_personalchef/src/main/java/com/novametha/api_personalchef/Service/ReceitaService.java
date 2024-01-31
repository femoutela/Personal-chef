package com.novametha.api_personalchef.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.novametha.api_personalchef.Repository.ReceitaRepository;

import com.novametha.api_personalchef.model.Receita;

@Service
public class ReceitaService {
    @Autowired
    private ReceitaRepository receitaRepository;

    public List<Receita> obterTodasAsReceitas() {
        return (List<Receita>) receitaRepository.findAll();
    }

    public Receita salvarReceita(Receita receita) {
        return receitaRepository.save(receita);
    }

 
}
