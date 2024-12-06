package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.Wrappers.UtilisateurWrapper;
import com.example.model.Utilisateur;

@Service
public class UtilisateurService {
 
    @Autowired
    private JdbcTemplate jdbcTemplate;
  


   public List<Utilisateur> getAll(){
        String sql = "SELECT * FROM utilisateur;";
        return this.jdbcTemplate.query(sql, new UtilisateurWrapper());
   } 
  
  

   public void save(Utilisateur utilisateur) {
     String sql = "INSERT INTO utilisateur (nom, prenom, adresse, telephone, mail) VALUES (?, ?, ?, ?, ?)";
     jdbcTemplate.update(sql, utilisateur.getNom(), utilisateur.getPrenom(), utilisateur.getAdresse(), utilisateur.getTelephone(), utilisateur.getMail() );
 }

 public boolean deleteUserById(Long id) {
          String sql = "DELETE FROM utilisateur WHERE id = ?";     
          int rowsAffected = jdbcTemplate.update(sql, id);     
         return rowsAffected > 0;
 }
 



 public Utilisateur getByID(Long id){
      String sql = "SELECT * FROM utilisateur WHERE id= ?";
      return this.jdbcTemplate.queryForObject(sql, new UtilisateurWrapper(),id);
  }

public int patchUser(Long id, Utilisateur utilisateur) {
     String sql = "UPDATE utilisateur SET nom = ?, prenom = ?, adresse = ?, telephone = ?, mail = ? WHERE id = ?";
 
     // Exécution de la requête SQL avec les nouveaux champs (username, email) et l'ID de l'utilisateur
     return jdbcTemplate.update(sql, 
                                utilisateur.getNom(), 
                                utilisateur.getPrenom(),
                                utilisateur.getAdresse(),
                                utilisateur.getTelephone(),
                                utilisateur.getMail(),                                
                                id);
 }
}


// public int insert(Utilisateur utilisateur){
//    String sql = "INSERT INTO utilisateur(id, date_creation, statut, adresse_depart, adresse_destination, id_1) VALUES (?,?,?,?,?,?)";
//    return this.jdbcTemplate.update(sql, utilisateur.getId(), utilisateur.getDate_creation(), utilisateur.getStatut(), utilisateur.getAdresse_depart(), utilisateur.getAdresse_destination, utilisateur.getId_1());
// }

// public void update(Etudiant etudiant) {
//     // TODO Auto-generated method stub
//     throw new UnsupportedOperationException("Unimplemented method 'update'");
// }

// public void delete(int id) {
//     String sql = "DELETE FROM etudiants WHERE id_etudiant = ?";
//         this.jdbcTemplate.update(sql, id);
// }
   
// }
