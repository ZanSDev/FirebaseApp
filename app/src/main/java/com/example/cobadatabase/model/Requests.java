package com.example.cobadatabase.model;

import java.io.Serializable;

public class Requests implements Serializable {


    private String nama;
    private String email;
    private String status;


    public Requests(String nama, String email, String status) {
        this.nama = nama;
        this.email = email;
        this.status = status;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    @Override
    public String toString(){
        return " "+nama+"\n"+
                " "+email+"\n"+
                 " "+status+"\n";
    }
}
