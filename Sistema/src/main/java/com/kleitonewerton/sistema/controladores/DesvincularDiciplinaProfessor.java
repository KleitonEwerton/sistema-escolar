/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.sistema.controladores;

import com.kleitonewerton.sistema.Professor;
import com.kleitonewerton.sistema.views.Tela;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author KleitonEwerton
 */
public class DesvincularDiciplinaProfessor implements ActionListener{

    private final Tela tela;

    public DesvincularDiciplinaProfessor(Tela tela) {
        this.tela = tela;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        int indexLinha = this.tela.getTableProfessores().getSelectedRow();
        
        if( indexLinha < 0)return;
        
        try{
            
                
               Professor professor = this.tela.getModelProfessores().getProfessor(indexLinha);
               System.out.println(tela.getDiciplinaCodeInputProfessor().getText());
               professor.removeDiciplina(tela.getDiciplinaCodeInputProfessor().getText());
                
               tela.getModelProfessores().atualizarTabela();
            
            
        }catch(Exception ex){
            
            System.out.println("ERRO");
            
        }
        
    }
    
}