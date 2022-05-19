/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.sistema.tabelas;

import com.kleitonewerton.sistema.Materia;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author KleitonEwerton
 */
public class TableDiciplinas extends AbstractTableModel implements Tables {

    private final String[] colunas = new String[]{"CODIGO", "NOME", "CARGA HORÁRIA", "RESPONSAVEL", "QUANTIDADE DE ALUNOS"};
    private final List<Materia> listDiciplina = new ArrayList<>();

    public TableDiciplinas() {

    }

    @Override
    public String getColumnName(int indexColuna) {

        return colunas[indexColuna];

    }

    @Override
    public int getRowCount() {
        return this.listDiciplina.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public Object getValueAt(int indexLinha, int indexColuna) {

        switch (indexColuna) {

            case 0:
                return this.listDiciplina.get(indexLinha).getCodigo();
            case 1:
                return this.listDiciplina.get(indexLinha).getName();
            case 2:
                return this.listDiciplina.get(indexLinha).getCargaHoraria();
            case 3:
                return this.listDiciplina.get(indexLinha).getResponsavel();
            case 4:
                return this.listDiciplina.get(indexLinha).getQntAlunos();
        }
        return null;

    }

    @Override
    public void removeObj(int indexLinha) {

        this.listDiciplina.remove(indexLinha);
        this.fireTableRowsDeleted(indexLinha, indexLinha);

    }

    @Override
    public void atualizarTabela() {
        this.fireTableDataChanged();

    }

    @Override
    public List getList() {
        return this.listDiciplina;
    }

    public void addObj(Materia materia) {

        this.listDiciplina.add(materia);
        this.fireTableDataChanged();
    }

    public Materia getDiciplina(int indexProduto) {
        return this.listDiciplina.get(indexProduto);
    }

    public void removeDiciplina(String code) {
        
        for (int i = 0; i < listDiciplina.size(); i++) {
            if (listDiciplina.get(i).getCodigo().equals(code)) {
                listDiciplina.remove(i);
                
            }
        }

    }

    public Materia getDiciplinaByCode(String code) {

        for (Materia mat : listDiciplina) {
            if (mat.getCodigo().equals(code)) {
                return mat;
            }
        }
        return null;
    }

    @Override
    public boolean contains(String value) {
        for (Materia mat : listDiciplina) {
            if (mat.getCodigo().equals(value)) {
                return true;
            }
        }

        return false;
    }
}
