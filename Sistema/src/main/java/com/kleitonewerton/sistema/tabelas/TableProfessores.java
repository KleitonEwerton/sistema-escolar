/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.sistema.tabelas;


import com.kleitonewerton.sistema.Professor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author KleitonEwerton
 */
public class TableProfessores extends AbstractTableModel{
    
    private final String[] colunas = new String[]{"NOME","MATRICULA", "DICIPLINAS"};
    private final List<Professor> listProfessores = new ArrayList<>();    
    
   
    public TableProfessores(){
        
    }
    
    @Override
    public String getColumnName(int indexColuna){
        
        return colunas[indexColuna];
        
    }
    
    @Override 
    public int getRowCount() {
        return this.listProfessores.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public Object getValueAt(int indexLinha, int indexColuna) {
        
        switch(indexColuna){
            
            case 0:
                return this.listProfessores.get(indexLinha).getNome();      
            case 1:
                return this.listProfessores.get(indexLinha).getMatricula();    
            case 2:
                return this.listProfessores.get(indexLinha).getDiciplinas();    
        }
        return null;
        
    }
   
    public void addNovoProfessor(Professor professor){
        
        this.listProfessores.add(professor);     
        this.fireTableDataChanged();          
    }
    
    public void removeProfessor(int indexLinha){
        
        this.listProfessores.remove(indexLinha);                      //Remove a linha
        this.fireTableRowsDeleted(indexLinha,indexLinha);//Atualiza a tabela
        
    }
  
    public Professor getProfessor(int indexProduto){
        return this.listProfessores.get(indexProduto);
    }
    public void atualizarTabela(){
        
        this.fireTableDataChanged();      
        
    }
     public List getList(){
        return this.listProfessores;
    }
}
