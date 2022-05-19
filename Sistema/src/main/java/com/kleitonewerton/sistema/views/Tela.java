/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.sistema.views;

/**
 *
 * @author KleitonEwerton
 */

import com.kleitonewerton.sistema.Aluno;
import com.kleitonewerton.sistema.controladores.AdicionarNovoAluno;
import com.kleitonewerton.sistema.controladores.AdicionarNovoProfessor;
import com.kleitonewerton.sistema.controladores.AlterarValorAlunos;
import com.kleitonewerton.sistema.controladores.AlterarValorProfessores;
import com.kleitonewerton.sistema.controladores.RemoverAluno;
import com.kleitonewerton.sistema.controladores.RemoverProfessor;
import com.kleitonewerton.sistema.tabelas.TableAlunos;
import com.kleitonewerton.sistema.tabelas.TableProfessores;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author KleitonEwerton
 */
public class Tela extends JFrame{
    
    private JTabbedPane menuBar;
    private JPanel panelAlunos;
     private JPanel panelProfessores;
    private JPanel primeiroPainelAlunos;
    private JPanel segundoPainelAlunos;
    private JPanel primeiroPainelProfessores;
    private JPanel segundoPainelProfessores;
    private final int altura = 600;
    private final int largura = 1300;
    
    private TableAlunos modelAlunos;
    private JTable tableAlunos;
    private TableProfessores modelProfessores;
    private JTable tableProfessores;
   
    private JTextField nomeInputAluno;
    private JTextField matriculaInputAluno;
    private JTextField diciplinasInputAluno;
    private JTextField nomeInputProfessor;
    private JTextField matriculaInputProfessor;
    private JTextField diciplinasInputProfessor;
    
 
    public Tela(){
        super("SISTEMA ESCOLAR");
        
    }
  
    public void draw(){
        this.panelProfessores = new JPanel();
        this.panelProfessores.setLayout(new BorderLayout());
        this.panelAlunos = new JPanel();
        this.panelAlunos.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(this.largura,this.altura);
        this.setResizable(false);
        this.setLocationRelativeTo(null); 
        
        drawSegundoPainel();
        drawPrimeiroPainel();
        
        GridLayout grid = new GridLayout(0,2,0,5);
        
        this.panelAlunos.setLayout(grid);
        this.panelProfessores.setLayout(grid);
         
        this.panelAlunos.add(this.segundoPainelAlunos);
        this.panelAlunos.add(this.primeiroPainelAlunos);
        this.panelProfessores.add(this.segundoPainelProfessores);
        this.panelProfessores.add(this.primeiroPainelProfessores);
        
        this.menuBar = new JTabbedPane();
        this.menuBar.add(this.panelProfessores,"Professores");
        this.menuBar.add(this.panelAlunos,"Alunos");
        this.add(menuBar);
        
        Aluno aluno = new Aluno ("eee","ooo");
        aluno.addNovaDiciplina("erere", 32);
        this.modelAlunos.addNovoAluno(aluno);
        
        this.setVisible(true);
    }
    
    private void drawPrimeiroPainel(){
        
        drawPrimeiroPainelAlunos();
        drawPrimeiroPainelProfessores();
   
    }
    
    private void drawSegundoPainel(){
        
        drawSegundoPainelProfessores();
        drawSegundoPainelAlunos();
        
        
    }
    
    private void drawPrimeiroPainelAlunos(){
        
        this.primeiroPainelAlunos = new JPanel();
        this.primeiroPainelAlunos.setLayout(new BorderLayout());
                                                      
        
        this.modelAlunos = new TableAlunos();
        
        
        tableAlunos = new JTable(modelAlunos);
        tableAlunos.setVisible(true);
       
        this.tableAlunos.getSelectionModel().addListSelectionListener(new  AlterarValorAlunos(this));
        
        this.primeiroPainelAlunos.add(new JScrollPane(tableAlunos));
        
    }
    
    private void drawPrimeiroPainelProfessores(){
        
        this.primeiroPainelProfessores = new JPanel();
        this.primeiroPainelProfessores.setLayout(new BorderLayout());  
        this.modelProfessores = new TableProfessores();
        
        tableProfessores = new JTable(modelProfessores);
        tableProfessores.setVisible(true);
       
        this.tableProfessores.getSelectionModel().addListSelectionListener(new  AlterarValorProfessores(this));
        this.primeiroPainelProfessores.add(new JScrollPane(tableProfessores));
        
    }
    
    private void drawSegundoPainelAlunos(){
        this.segundoPainelAlunos = new JPanel();
        this.segundoPainelAlunos.setBorder(BorderFactory.createTitledBorder("ALUNOS"));
        this.segundoPainelAlunos.setLayout(new GridLayout(2,0,80, 0));
        
        JPanel painel1 = new JPanel();
        JPanel painel2 = new JPanel();
        
        painel1.setLayout(new GridLayout(4,2,20,10));
        
        JLabel nome = new JLabel("NOME: ");
        JLabel valor = new JLabel("MATRÍCULA ");
        JLabel descricao = new JLabel("DICIPLINAS COM AULAS: ");
        JButton btnAdicionar = new JButton("ADICIONAR ALUNO");
        JButton btnRemover = new JButton("REMOVER PROFESSOR");
        
        this.matriculaInputAluno = new JTextField(50);
        this.nomeInputAluno = new JTextField(50);
        this.diciplinasInputAluno = new JTextField(50);
        btnAdicionar.addActionListener(new AdicionarNovoAluno(this));
        btnRemover.addActionListener(new RemoverAluno(this));
        
        
        painel1.add(nome);
        painel1.add(nomeInputAluno);
        
        painel1.add(valor);
        painel1.add(matriculaInputAluno );
       
         
        painel1.add(descricao);
        painel1.add(diciplinasInputAluno);
        
        painel2.add(btnAdicionar);
        painel2.add(btnRemover);
        
        this.segundoPainelAlunos.add(painel1);
        this.segundoPainelAlunos.add(painel2);
    }
    
    private void drawSegundoPainelProfessores(){
        this.segundoPainelProfessores = new JPanel();
        this.segundoPainelProfessores.setBorder(BorderFactory.createTitledBorder("Professores"));
        this.segundoPainelProfessores.setLayout(new GridLayout(2,0,20, 0));
        
        JPanel painel1 = new JPanel();
        JPanel painel2 = new JPanel();
        
        painel1.setLayout(new GridLayout(5,2,20,30));
        
        JLabel nome = new JLabel("NOME: ");
        JLabel valor = new JLabel("MATRÍCULA ");
        JLabel descricao = new JLabel("DICIPLINAS COM AULAS: ");
        JButton btnAdicionar = new JButton("ADICIONAR PROFESSOR");
        JButton btnRemover = new JButton("REMOVER ALUNO");
        
        this.matriculaInputProfessor = new JTextField(50);
        this.nomeInputProfessor = new JTextField(50);
        this.diciplinasInputProfessor = new JTextField(50);
        btnAdicionar.addActionListener(new AdicionarNovoProfessor(this));
        btnRemover.addActionListener(new RemoverProfessor(this));
        
        
        painel1.add(nome);
        painel1.add(nomeInputProfessor);
        
        painel1.add(valor);
        painel1.add(matriculaInputProfessor );
       
         
        painel1.add(descricao);
        painel1.add(diciplinasInputProfessor);
        
        painel2.add(btnAdicionar);
        painel2.add(btnRemover);
        
        this.segundoPainelProfessores.add(painel1);
        this.segundoPainelProfessores.add(painel2);
    }
    
    public TableProfessores getModelProfessores() {
        return this.modelProfessores;
    }

    public JTable getTableProfessores() {
        return this.tableProfessores;
    }
    
    public TableAlunos getModelAlunos() {
        return this.modelAlunos;
    }

    public JTable getTableAlunos() {
        return this.tableAlunos;
    }
    
    
    public JTextField getNomeInputAluno() {
        return this.nomeInputAluno;
    }

     public JTextField getDiciplinasInputAluno() {
        return this.diciplinasInputAluno;
    }

     public JTextField getMatriculaInputAluno() {
        return this.matriculaInputAluno;
    }
     
      public JTextField getNomeInputProfessor() {
        return this.nomeInputProfessor;
    }

     public JTextField getDiciplinasInputProfessor() {
        return this.diciplinasInputProfessor;
    }

     public JTextField getMatriculaInputProfessor() {
        return this.matriculaInputProfessor;
    }
    
    
}