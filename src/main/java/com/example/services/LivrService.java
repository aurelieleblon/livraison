package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.Wrappers.LivrWrapper;
import com.example.model.Livraison;

@Service
public class LivrService {
 
    @Autowired
    private JdbcTemplate jdbcTemplate;
  
    

   public List<Livraison> getAll(){
        String sql = "SELECT * FROM livraison;";
        return this.jdbcTemplate.query(sql, new LivrWrapper());
   } }

//    public Etudiant getByID(int id){
//         String sql = "SELECT * FROM etudiants WHERE id_etudiant= ?";
//         return this.jdbcTemplate.queryForObject(sql, new EtudiantWrapper(),id);
//    }
//    public int insert(Etudiant etudiant){
//         String sql = "INSERT INTO etudiants(nom_etudiant, mail_etudiant, telephone_etudiant, adresse_etudiant, prenom_etudiant) VALUES (?,?,?,?,?)";
//         return this.jdbcTemplate.update(sql, etudiant.getNom(), etudiant.getEmail(), etudiant.getTelephone(), etudiant.getTelephone(), etudiant.getAdresse());
//     }

// public void update(Etudiant etudiant) {
//     // TODO Auto-generated method stub
//     throw new UnsupportedOperationException("Unimplemented method 'update'");
// }

// public void delete(int id) {
//     String sql = "DELETE FROM etudiants WHERE id_etudiant = ?";
//         this.jdbcTemplate.update(sql, id);
// }
   
// }