/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.sistema;


/**
 *
 * @author KleitonEwerton
 */
public class Materia implements Diciplina{
     
    private int cargaHoraria;
    private String codigo;

    public Materia(int cargaHoraria, String codigo) {
        this.cargaHoraria = cargaHoraria;
        this.codigo = codigo;
    }
    
    
    @Override
    public int getCargaHoraria() {
        return this.cargaHoraria;
    }

    @Override
    public String getCodigo() {
        return this.codigo;
    }
    
}
