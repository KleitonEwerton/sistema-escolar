/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.sistema;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KleitonEwerton
 */
public class Professor extends Usuario{
    
    private final List<Aluno> listaAlunos = new ArrayList<>();

    
    public Professor(String nome, int numeroDeRegistro) {
        
        super(nome, numeroDeRegistro);
        
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }
    
    
    
}
