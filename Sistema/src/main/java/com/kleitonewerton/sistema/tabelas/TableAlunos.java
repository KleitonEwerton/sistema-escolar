/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.sistema.tabelas;

import com.kleitonewerton.sistema.Aluno;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author KleitonEwerton
 */
public class TableAlunos extends AbstractTableModel{
    
    private final String[] colunas = new String[]{"NOME","MATRICULA", "AULAS"};
    private final List<Aluno> listAulos = new ArrayList<>();    
    
   
    public TableAlunos(){
        
    }
    
    @Override
    public String getColumnName(int indexColuna){
        
        return colunas[indexColuna];
        
    }
    
    @Override 
    public int getRowCount() {
        return this.listAulos.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public Object getValueAt(int indexLinha, int indexColuna) {
        
        switch(indexColuna){
            
            case 0:
                return this.listAulos.get(indexLinha).getNome();      
            case 1:
                return this.listAulos.get(indexLinha).getMatricula();    
            case 2:
                return this.listAulos.get(indexLinha).getDiciplinas();    
        }
        return null;
        
    }
   
    public void addNovoAluno(Aluno aluno){
        
        this.listAulos.add(aluno);     
        this.fireTableDataChanged();          
    }
    
    public void removeAluno(int indexLinha){
        
        this.listAulos.remove(indexLinha);                      //Remove a linha
        this.fireTableRowsDeleted(indexLinha,indexLinha);//Atualiza a tabela
        
    }
  
    public Aluno getAluno(int indexProduto){
        return this.listAulos.get(indexProduto);
    }
    public void atualizarTabela(){
         this.fireTableDataChanged();      
        
    }
    
    public List getList(){
        return this.listAulos;
    }
}