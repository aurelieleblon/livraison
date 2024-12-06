package com.example.Wrappers;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.model.Utilisateur;

public class UtilisateurWrapper implements RowMapper<Utilisateur> {

    @Override
    public Utilisateur mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Utilisateur(
                        rs.getString("nom"), 
                        rs.getString("prenom"), 
                        rs.getString("adresse"), 
                        rs.getString("telephone"), 
                        rs.getString("mail")
        );
    }
    
}

