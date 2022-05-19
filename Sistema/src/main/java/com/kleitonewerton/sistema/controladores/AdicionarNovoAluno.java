/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.sistema.controladores;

import com.kleitonewerton.sistema.Aluno;
import com.kleitonewerton.sistema.views.Tela;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author KleitonEwerton
 */

public class AdicionarNovoAluno implements ActionListener{

    private final Tela tela;

    public AdicionarNovoAluno(Tela tela) {
        this.tela = tela;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String nome = tela.getNomeInputAluno().getText();
        String matricula = tela.getMatriculaInputAluno().getText(); 
        String diciplina = tela.getDiciplinasInputAluno().getText();
        diciplina = diciplina.replace(" ", "");
        String[] disciplinas = diciplina.split(",");
        
        double valor;
        int quantidade;
        
        
        if(nome.equals("" )){
            JOptionPane.showMessageDialog(null, "ERRO AO ADICIONAR\nNOME OBRIGATÓRIO", "ERRO",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(matricula.equals("" )){
            JOptionPane.showMessageDialog(null, "ERRO AO ADICIONAR\nNOME OBRIGATÓRIO", "ERRO",JOptionPane.ERROR_MESSAGE);
            return;
        }
        Aluno aluno = new Aluno(nome, matricula);
        
        
        
        this.tela.getModelAlunos().addNovoAluno(aluno);
        
    }
    
}