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
public class VincularDiciplinaProfessor implements ActionListener {

    private final Tela tela;

    public VincularDiciplinaProfessor(Tela tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int indexLinha = this.tela.getTableProfessores().getSelectedRow();

        if (indexLinha < 0) {

            JOptionPane.showMessageDialog(null, "PRIMEIRO SELECIONE UM PROFESSOR", "INFO", JOptionPane.INFORMATION_MESSAGE);
            return;

        }

        if (tela.getDiciplinaNameInputProfessor().getText().equals("") || tela.getDiciplinaCodeInputProfessor().getText().equals("") || tela.getDiciplinaCHInputProfessor().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "ERRO AO ADICIONAR\nNOME, CODIGO E CARGA HORARIA OBRIGATORIOS", "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (tela.containsCode(tela.getDiciplinaCodeInputProfessor().getText())) {
            JOptionPane.showMessageDialog(null, "ERRO AO ADICIONAR\nCODIGO JÁ USADO", "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {

            int ch = Integer.parseInt(tela.getDiciplinaCHInputProfessor().getText());
            Professor professor = this.tela.getModelProfessores().getProfessor(indexLinha);
            professor.addNovaDiciplina(tela.getDiciplinaNameInputProfessor().getText(), tela.getDiciplinaCodeInputProfessor().getText(), ch);
            tela.getModelDiciplinas().addObj(new Materia(tela.getDiciplinaNameInputProfessor().getText(), tela.getDiciplinaCodeInputProfessor().getText(), ch, professor.getNome()));
            tela.getModelProfessores().atualizarTabela();
            tela.cleanFilds();

        } catch (NumberFormatException exn) {
            JOptionPane.showMessageDialog(null, "CARGA HORARIA INVALIDA", "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {

            System.out.println("ERRO" + ex);

        }

    }

}
