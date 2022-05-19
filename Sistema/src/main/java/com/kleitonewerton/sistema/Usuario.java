/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.sistema;

/**
 *
 * @author KleitonEwerton
 */
abstract class Usuario {
    
    private String nome;
    private String matricula;

    public Usuario(String nome,  String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String numeroDeRegistro) {
        this.matricula = numeroDeRegistro;
    }
    
    
    
}
