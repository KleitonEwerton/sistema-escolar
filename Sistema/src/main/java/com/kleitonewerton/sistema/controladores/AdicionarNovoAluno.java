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
       
        
        if(nome.equals("" )){
            JOptionPane.showMessageDialog(null, "ERRO AO ADICIONAR\nNOME OBRIGATÓRIO", "ERRO",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(matricula.equals("" )){
            JOptionPane.showMessageDialog(null, "ERRO AO ADICIONAR\nMATRICULA OBRIGATÓRIO", "ERRO",JOptionPane.ERROR_MESSAGE);
            return;
        }
        Aluno aluno = new Aluno(nome, matricula);
        
        String disc = "";
        for(int i  = 0; i < disciplinas.length;i++){
            
            if(tela.materiaValida(disciplinas[i])){
                aluno.addNovaDiciplina(disciplinas[i]);
                tela.getModelDiciplinas().getDiciplinaByCode(disciplinas[i]).maisUmAluno();
                tela.cleanFilds();
                disc += disciplinas[i] + ", ";
            }
            
        }
        
         JOptionPane.showMessageDialog(null, "Aluno matriculado\nAs diciplinas ( " + disc + " ) foram encontradas e vinculadas com sucesso", "INFO",JOptionPane.INFORMATION_MESSAGE);
        
        this.tela.getModelAlunos().addNovoAluno(aluno);
        tela.cleanFilds();
    }
    
    
    
}