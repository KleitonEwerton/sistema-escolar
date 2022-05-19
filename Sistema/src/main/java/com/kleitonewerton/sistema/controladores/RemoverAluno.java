/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.sistema.controladores;

import com.kleitonewerton.sistema.Aluno;
import com.kleitonewerton.sistema.views.Tela;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author KleitonEwerton
 */

public class RemoverAluno implements ActionListener{

    private final Tela tela;

    public RemoverAluno(Tela tela) {
        this.tela = tela;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        int indexLinha = this.tela.getTableAlunos().getSelectedRow();
        
        try{
            
            Aluno aluno = this.tela.getModelAlunos().getAluno(indexLinha);
            List<String> listaDiciplinas  = aluno.getListaDiciplinas();
            
            for(String dic: listaDiciplinas)
                tela.getModelDiciplinas().getDiciplinaByCode(dic).menosUmAluno();
            
            this.tela.getModelAlunos().removeObj(indexLinha);
            tela.cleanFilds();
            
        }catch(Exception ex){
            
            JOptionPane.showMessageDialog(null, "NENHUMA LINHA SELECIONADA, IMPOSSÍVEL REMOVER", "ERRO",JOptionPane.ERROR_MESSAGE);
            
        }
        
    }
    
}