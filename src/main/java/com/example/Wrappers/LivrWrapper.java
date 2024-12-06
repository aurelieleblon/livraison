package com.example.Wrappers;



import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.model.Livraison;


public class LivrWrapper implements RowMapper<Livraison> {

    @Override
    public Livraison mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Livraison(
                        rs.getInt("id"), 
                        rs.getString("date_creation"), 
                        rs.getString("statut"), 
                        rs.getString("adresse_depart"), 
                        rs.getString("adresse_destination"), 
                        rs.getInt("id_1")
        );
    }
    
}
