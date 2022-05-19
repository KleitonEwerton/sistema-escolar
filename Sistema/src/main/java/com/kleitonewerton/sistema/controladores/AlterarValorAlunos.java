/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.sistema.controladores;

import com.kleitonewerton.sistema.Aluno;
import com.kleitonewerton.sistema.views.Tela;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author KleitonEwerton
 */

public class AlterarValorAlunos  implements ListSelectionListener{

    private Tela tela;

    public AlterarValorAlunos(Tela tela) {
        this.tela = tela;
    }
    
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        
        int indexLinha = this.tela.getTableAlunos().getSelectedRow();
        
        if( indexLinha < 0)return;
        
        try{
            
                Aluno aluno = this.tela.getModelAlunos().getAluno(indexLinha);
                tela.getNomeInputAluno().setText(aluno.getNome());
                tela.getMatriculaInputAluno().setText(aluno.getMatricula());
                tela.getDiciplinasInputAluno().setText(aluno.getDiciplinas());
                
            
        }catch(Exception ex){
            
            System.out.println("ERRO");
            
        }
        
    }

    
}