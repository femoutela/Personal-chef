package com.novametha.api_personalchef.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.novametha.api_personalchef.Repository.InsumoRepository;
import com.novametha.api_personalchef.Repository.ReceitaRepository;
import com.novametha.api_personalchef.model.Insumo;
import com.novametha.api_personalchef.model.InsumoQuantidade;
import com.novametha.api_personalchef.model.Receita;

import jakarta.transaction.Transactional;



@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/receitas")
public class ReceitaController {
    
    @Autowired
    private ReceitaRepository receitaRepository;

    @Autowired
    private InsumoRepository insumoRepository;

    @Transactional
    @PostMapping
    public ResponseEntity<String> cadastrarReceita(@RequestBody Receita receita) {
        try {
            for (InsumoQuantidade insumoQuantidade : receita.getInsumos()) {
                Insumo insumo = insumoQuantidade.getInsumo();
                insumoRepository.save(insumo);  // Salva ou atualiza o insumo

                // Atualiza a referência do insumo na InsumoQuantidade
                insumoQuantidade.setInsumo(insumo);
            }

            receitaRepository.save(receita);

            return new ResponseEntity<>("Receita cadastrada com sucesso", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao cadastrar a receita: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Outros métodos...
}