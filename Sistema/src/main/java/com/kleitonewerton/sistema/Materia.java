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
public class Materia implements Disciplina{
     
    private final List<Integer> listaNotas = new ArrayList<>();
    private int faltas = 0;
    
    @Override
    public double getNotaFinal() {
        
        double notaFinal = 0;
        for(Integer nota : this.listaNotas)
{
            notaFinal += nota;
}
        
        return  notaFinal ;
    }

    @Override
    public int getFaltas() {
        return this.faltas;
    }
    
    public void novaFalta(){
        this.faltas += 1;
    }
    
}
