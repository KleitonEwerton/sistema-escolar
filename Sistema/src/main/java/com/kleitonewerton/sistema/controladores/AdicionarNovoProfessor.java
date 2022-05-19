/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.sistema.controladores;

import com.kleitonewerton.sistema.Aluno;
import com.kleitonewerton.sistema.Professor;
import com.kleitonewerton.sistema.views.Tela;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author KleitonEwerton
 */

public class AdicionarNovoProfessor implements ActionListener{

    private final Tela tela;

    public AdicionarNovoProfessor(Tela tela) {
        this.tela = tela;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String nome = tela.getNomeInputProfessor().getText();
        String matricula = tela.getMatriculaInputProfessor().getText(); 
        String diciplina = tela.getDiciplinasInputProfessor().getText();
        diciplina = diciplina.replace(" ", "");
        String[] disciplinas = diciplina.split(",");
        
        double valor;
        int quantidade;
       
        if(nome.equals("" )){
            JOptionPane.showMessageDialog(null, "ERRO AO ADICIONAR\nNOME OBRIGATÓRIO", "ERRO",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(matricula.equals("" )){
            JOptionPane.showMessageDialog(null, "ERRO AO ADICIONAR\nMATRÍCULA OBRIGATÓRIO", "ERRO",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Professor professor = new Professor(nome, matricula);
        
        for(int i  =0; i<disciplinas.length;i++)
            professor.addNovaDiciplina(disciplinas[i], 60);
        
        this.tela.getModelProfessores().addNovoProfessor(professor);
        
    }
    
}