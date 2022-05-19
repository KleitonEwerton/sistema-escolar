/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.sistema.controladores;

import com.kleitonewerton.sistema.Professor;
import com.kleitonewerton.sistema.views.Tela;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author KleitonEwerton
 */
public class DesvincularDiciplinaProfessor implements ActionListener {

    private final Tela tela;

    public DesvincularDiciplinaProfessor(Tela tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int indexLinha = this.tela.getTableProfessores().getSelectedRow();

        if (indexLinha < 0) {
            JOptionPane.showMessageDialog(null, "SELECIONE UM PROFESSOR", "ERRO", JOptionPane.ERROR_MESSAGE);

            return;
        }
        if ((tela.getDiciplinaCodeInputProfessor().getText()).equals("")) {
            JOptionPane.showMessageDialog(null, "DIGITE UM CODICO DE DICIPLINA", "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!tela.getModelDiciplinas().contains(tela.getDiciplinaCodeInputProfessor().getText())) {
            JOptionPane.showMessageDialog(null, "CODIGO INVALIDO", "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {

            Professor professor = this.tela.getModelProfessores().getProfessor(indexLinha);

            System.out.println(tela.getDiciplinaCodeInputProfessor().getText());
            professor.removeDiciplina(tela.getDiciplinaCodeInputProfessor().getText());
            tela.getModelDiciplinas().removeDiciplina(tela.getDiciplinaCodeInputProfessor().getText());
            tela.getModelDiciplinas().atualizarTabela();
            tela.getModelProfessores().atualizarTabela();

            tela.getModelAlunos().removeDiciplinaByCode(tela.getDiciplinaCodeInputProfessor().getText());
            tela.cleanFilds();

        } catch (Exception ex) {

            System.out.println("ERRO");

        }

    }

}
