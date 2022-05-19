/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.sistema.controladores;

import com.kleitonewerton.sistema.Professor;
import com.kleitonewerton.sistema.views.Tela;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class AlterarValorProfessores implements ListSelectionListener {

    private Tela tela;

    public AlterarValorProfessores(Tela tela) {
        this.tela = tela;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

        int indexLinha = this.tela.getTableProfessores().getSelectedRow();

        if (indexLinha < 0) {
            return;
        }

        try {

            Professor professor = this.tela.getModelProfessores().getProfessor(indexLinha);
            tela.getNomeInputProfessor().setText(professor.getNome());

            tela.getMatriculaInputProfessor().setText(professor.getMatricula());

        } catch (Exception ex) {

            System.out.println("ERRO");

        }

    }

}
