package com.example.demo.entity;

public class Pessoa {
    private int id;
    private String nome,email,cargo;
    public Pessoa(int id, String nome, String email, String cargo) {
        this.id = id; this.nome = nome; this.email = email; this.cargo = cargo;
    }
    public int getId() { return id;}
    public void setId(int id) { this.id = id;}
    public String getNome() { return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo;}
}

