/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.sistema.controladores;

import com.kleitonewerton.sistema.views.Tela;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author KleitonEwerton
 */
public class RemoverProfessor implements ActionListener{

    private final Tela tela;

    public RemoverProfessor (Tela tela) {
        this.tela = tela;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        int indexLinha = this.tela.getTableProfessores().getSelectedRow();
        
        try{
            
            this.tela.getModelProfessores().removeProfessor(indexLinha);
            
    }catch(Exception ex){

        JOptionPane.showMessageDialog(null, "NENHUMA LINHA SELECIONADA, IMPOSSÍVEL REMOVER", "ERRO",JOptionPane.ERROR_MESSAGE);

    }
        
    }
    
}