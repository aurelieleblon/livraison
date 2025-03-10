package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.services.LivrService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// 5 TYPES DE REQUÊTES HTTP/HTTPS
// GET -> Récuperer des données
// POST -> Ajouter des données
// DELETE -> Supprimer des données 
// PATCH -> Modifier des données 
// PUT -> Modifier des données
// Préciser la route du controllers 
// exemple /etudiants
// Controllers
@Controller
@RequestMapping("/livraison")
public class LivrController {

    @Autowired //instancie un nouveau etudiantService
    private LivrService livrService;
    @Autowired
    private ObjectMapper objectMapper;

    // GET
    //exemple /
    //Utilisateur va devoir aller sur /etudiants/
    @GetMapping //précise à l'app que cette fonction va faire partie d'un appel get
    public ResponseEntity<String> getAll() {
        try {
            String jsonData = objectMapper.writeValueAsString(livrService.getAll());
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
            return new ResponseEntity<>(jsonData, headers, HttpStatus.OK);
        } catch (JsonProcessingException ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }}
