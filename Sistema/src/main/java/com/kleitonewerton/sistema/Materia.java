/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.sistema;

/**
 *
 * @author KleitonEwerton
 */
public class Materia implements Diciplina {

    private final int cargaHoraria;
    private final String codigo;
    private final String name;
    private final String responsavel;
    private int qntAlunos = 0;

    public Materia(String name, String codigo, int cargaHoraria, String responsavel) {
        this.cargaHoraria = cargaHoraria;
        this.codigo = codigo;
        this.name = name;
        this.responsavel = responsavel;
    }

    @Override
    public int getCargaHoraria() {
        return this.cargaHoraria;
    }

    @Override
    public String getCodigo() {
        return this.codigo;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getResponsavel() {
        return responsavel;
    }

    @Override
    public int getQntAlunos() {
        return qntAlunos;
    }

    @Override
    public void menosUmAluno() {
        this.qntAlunos -= 1;
    }

    @Override
    public void maisUmAluno() {
        this.qntAlunos += 1;
    }

}
