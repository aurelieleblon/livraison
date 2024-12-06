package com.example.model;



public class Livraison {

    private int id;
    private String date_creation;
    private String statut;
    private String adresse_depart; 
    private String adresse_destination;
    private int id_1;
            
    
    

    public Livraison(int id, String date_creation, String statut, String adresse_depart, String adresse_destination, int id_1 ) {
        this.id = id;
        this.date_creation = date_creation;
        this.statut = statut;
        this.adresse_depart = adresse_depart;
        this.adresse_destination = adresse_destination;
        this.id_1 = id_1;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getAdresse_depart() {
        return adresse_depart;
    }

    public void setAdresse_depart(String adresse_depart) {
        this.adresse_depart = adresse_depart;
    }

    public int getId_1() {
        return id_1;
    }

    public void setId_1(int id_1) {
        this.id_1 = id_1;
    }

    public String getAdresse_destination() {
        return adresse_destination;
    }

    public void setAdresse_destination(String adresse_destination) {
        this.adresse_destination = adresse_destination;
    }



}