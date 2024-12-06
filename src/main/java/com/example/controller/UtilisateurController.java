package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Utilisateur;
import com.example.services.UtilisateurService;
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
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    @Autowired //instancie un nouveau etudiantService
    private UtilisateurService utilisateurService;
    @Autowired
    private ObjectMapper objectMapper;

    // GET
    //exemple /
    //Utilisateur va devoir aller sur /etudiants/
    @GetMapping //précise à l'app que cette fonction va faire partie d'un appel get
    public ResponseEntity<String> getAll() {
        try {
            String jsonData = objectMapper.writeValueAsString(utilisateurService.getAll());
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
            return new ResponseEntity<>(jsonData, headers, HttpStatus.OK);
        } catch (JsonProcessingException ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<String> getById(@PathVariable("id") Long id) {
        try {
            // Récupérer l'utilisateur par son ID
            Utilisateur utilisateur = utilisateurService.getByID(id);
            
            // Vérifier si l'utilisateur existe
            if (utilisateur != null) {
                // Convertir l'utilisateur en JSON
                String jsonData = objectMapper.writeValueAsString(utilisateur);
                HttpHeaders headers = new HttpHeaders();
                headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
                return new ResponseEntity<>(jsonData, headers, HttpStatus.OK);
            } else {
                // Si l'utilisateur n'est pas trouvé, retourner un code 404
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (JsonProcessingException ex) {
            // Gérer les erreurs de sérialisation JSON
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
   

    @PostMapping
    public ResponseEntity<String> createUtilisateur(@RequestBody Utilisateur utilisateur) {
        try {
            // Enregistrer l'utilisateur
            utilisateurService.save(utilisateur);

            // Retourner une réponse avec un code HTTP 201 (Created)
            return new ResponseEntity<>("Utilisateur créé avec succès", HttpStatus.CREATED);
        } catch (Exception ex) {
            // Retourner une réponse en cas d'erreur
            return new ResponseEntity<>("Erreur lors de la création de l'utilisateur", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


 @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        boolean isDeleted = utilisateurService.deleteUserById(id);
        if (isDeleted) {
            return ResponseEntity.ok("Utilisateur supprimé avec succès.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Utilisateur non trouvé.");
        }
}

@PatchMapping("/{id}")
public ResponseEntity<String> patchUser(@PathVariable("id") Long id, @RequestBody Utilisateur utilisateur) {
    int rowsAffected = utilisateurService.patchUser(id, utilisateur);
    
    if (rowsAffected > 0) {
        return new ResponseEntity<>("Utilisateur mis à jour avec succès.", HttpStatus.OK);
    } else {
        return new ResponseEntity<>("Utilisateur non trouvé.", HttpStatus.NOT_FOUND);
    }
}
}