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
    private final List<Materia> listaDisciplinas = new ArrayList<>();
    
    public Professor(String nome, String numeroDeRegistro) {
        
        super(nome, numeroDeRegistro);
        
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }
    public String getDiciplinas(){
        
        String diciplinas = "";
        for(Materia dic: this.listaDisciplinas){
            diciplinas += dic.getCodigo()+ ",";
        }
        return diciplinas;
    }  
    public void addNovaDiciplina(String codigo, int cargahoraria){
        
        this.listaDisciplinas.add(new Materia(cargahoraria, codigo));
        
    }
    
}
