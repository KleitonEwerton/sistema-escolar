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

   
    
    private final List<Diciplina> listaDiciplinas = new ArrayList<>();

    
    public Aluno(String nome, String numeroDeRegistro) {
        super(nome, numeroDeRegistro);
    }
    
    public String getDiciplinas(){
        
        String diciplinas = "";
        for(Diciplina dic: this.listaDiciplinas){
            diciplinas += dic.getCodigo() + ",";
        }
        return diciplinas;
    }   
  
    public void addNovaDiciplina(String codigo, int cargahoraria){
        
        listaDiciplinas.add(new Materia(cargahoraria, codigo));
        
    }
    
}
