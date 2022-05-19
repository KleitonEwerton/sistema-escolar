/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.sistema.controladores;


import com.kleitonewerton.sistema.Materia;
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
        
       
        
        
        
        
        this.tela.getModelProfessores().addObj(new Professor(nome, matricula));
        tela.cleanFilds();
        
    }
    
}