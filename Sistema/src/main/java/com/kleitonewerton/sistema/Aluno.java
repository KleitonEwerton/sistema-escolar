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
public class Aluno extends Usuario{

   
    
    private final List<String> listaDiciplinas = new ArrayList<>();

    
    public Aluno(String nome, String numeroDeRegistro) {
        super(nome, numeroDeRegistro);
    }
    
    public String getDiciplinas(){
        
        String diciplinas = "";
        for(String dic: this.listaDiciplinas){
            diciplinas += dic + ",";
        }
        return diciplinas;
    }   
  
    public void addNovaDiciplina(String codigo){
        
        listaDiciplinas.add(codigo);
        
    }
    
}
