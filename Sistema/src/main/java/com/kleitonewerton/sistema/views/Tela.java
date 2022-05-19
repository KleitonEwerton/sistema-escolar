/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.sistema.views;

/**
 *
 * @author KleitonEwerton
 */
import com.kleitonewerton.sistema.Materia;
import com.kleitonewerton.sistema.Professor;
import com.kleitonewerton.sistema.controladores.AdicionarNovoAluno;
import com.kleitonewerton.sistema.controladores.AdicionarNovoProfessor;
import com.kleitonewerton.sistema.controladores.AlterarValorAlunos;
import com.kleitonewerton.sistema.controladores.AlterarValorProfessores;
import com.kleitonewerton.sistema.controladores.DesvincularDiciplinaProfessor;
import com.kleitonewerton.sistema.controladores.RemoverAluno;
import com.kleitonewerton.sistema.controladores.RemoverProfessor;
import com.kleitonewerton.sistema.controladores.VincularDiciplinaProfessor;
import com.kleitonewerton.sistema.tabelas.TableAlunos;
import com.kleitonewerton.sistema.tabelas.TableDiciplinas;
import com.kleitonewerton.sistema.tabelas.TableProfessores;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
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
public class Tela extends JFrame {

    private JTabbedPane menuBar;
    private JPanel panelAlunos;
    private JPanel panelProfessores;
    private JPanel primeiroPainelAlunos;
    private JPanel segundoPainelAlunos;
    private JPanel primeiroPainelDiciplinas;
    private JPanel primeiroPainelProfessores;
    private JPanel segundoPainelProfessores;
    private final int altura = 600;
    private final int largura = 1300;

    private TableAlunos modelAlunos;
    private JTable tableAlunos;
    private TableProfessores modelProfessores;
    private JTable tableProfessores;
    private TableDiciplinas modelDiciplinas;
    private JTable tableDiciplinas;

    private JTextField nomeInputAluno;
    private JTextField matriculaInputAluno;
    private JTextField diciplinasInputAluno;
    private JTextField nomeInputProfessor;
    private JTextField matriculaInputProfessor;
    private JTextField diciplinaNameInputProfessor;
    private JTextField diciplinaCodeInputProfessor;
    private JTextField diciplinaCHInputProfessor;
    private JPanel panelDiciplinas;

    public Tela() {
        super("SISTEMA ESCOLAR");

    }

    public void draw() {
        this.panelProfessores = new JPanel();
        this.panelProfessores.setLayout(new BorderLayout());
        this.panelAlunos = new JPanel();
        this.panelAlunos.setLayout(new BorderLayout());
        this.panelDiciplinas = new JPanel();
        this.panelDiciplinas.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(this.largura, this.altura);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        drawSegundoPainel();
        drawPrimeiroPainel();

        GridLayout grid = new GridLayout(0, 2, 0, 5);

        this.panelAlunos.setLayout(grid);
        this.panelProfessores.setLayout(grid);
        this.panelDiciplinas.setLayout(new GridLayout(1,1,50,50));
        this.panelAlunos.add(this.segundoPainelAlunos);
        this.panelAlunos.add(this.primeiroPainelAlunos);
        this.panelProfessores.add(this.segundoPainelProfessores);
        this.panelProfessores.add(this.primeiroPainelProfessores);
        this.panelDiciplinas.add(this.primeiroPainelDiciplinas);
        this.menuBar = new JTabbedPane();
        this.menuBar.add(this.panelProfessores, "Professores");
        this.menuBar.add(this.panelAlunos, "Alunos");
        this.menuBar.add(this.panelDiciplinas, "Diciplinas");
        this.add(menuBar);

        this.setVisible(true);
    }

    private void drawPrimeiroPainel() {

        drawPrimeiroPainelAlunos();
        drawPrimeiroPainelProfessores();
        drawPrimeiroPainelDiciplinas();

    }

    private void drawSegundoPainel() {

        drawSegundoPainelProfessores();
        drawSegundoPainelAlunos();

    }

    private void drawPrimeiroPainelAlunos() {

        this.primeiroPainelAlunos = new JPanel();
        this.primeiroPainelAlunos.setLayout(new BorderLayout());

        this.modelAlunos = new TableAlunos();

        tableAlunos = new JTable(modelAlunos);
        tableAlunos.setVisible(true);

        this.tableAlunos.getSelectionModel().addListSelectionListener(new AlterarValorAlunos(this));

        this.primeiroPainelAlunos.add(new JScrollPane(tableAlunos));

    }

    private void drawPrimeiroPainelProfessores() {

        this.primeiroPainelProfessores = new JPanel();
        this.primeiroPainelProfessores.setLayout(new BorderLayout());
        this.modelProfessores = new TableProfessores();

        tableProfessores = new JTable(modelProfessores);
        tableProfessores.setVisible(true);

        this.tableProfessores.getSelectionModel().addListSelectionListener(new AlterarValorProfessores(this));
        this.primeiroPainelProfessores.add(new JScrollPane(tableProfessores));

    }

    private void drawPrimeiroPainelDiciplinas() {

        this.primeiroPainelDiciplinas = new JPanel();
        this.primeiroPainelDiciplinas.setLayout(new BorderLayout());
        this.modelDiciplinas = new TableDiciplinas();

        tableDiciplinas = new JTable(modelDiciplinas);
        tableDiciplinas.setVisible(true);

        //this.tableDiciplinas.getSelectionModel().addListSelectionListener(new AlterarValorProfessores(this));
        this.primeiroPainelDiciplinas.add(new JScrollPane(tableDiciplinas));

    }
    
    private void drawSegundoPainelAlunos() {
        this.segundoPainelAlunos = new JPanel();
        this.segundoPainelAlunos.setBorder(BorderFactory.createTitledBorder("ALUNOS"));
        this.segundoPainelAlunos.setLayout(new GridLayout(2, 0, 80, 0));

        JPanel painel1 = new JPanel();
        JPanel painel2 = new JPanel();

        painel1.setLayout(new GridLayout(5, 2, 20, 10));

        JLabel nome = new JLabel("Nome: ");
        JLabel valor = new JLabel("Matricula: ");
        JLabel descricao = new JLabel("Diciplinas com aulas: ");
        JButton btnAdicionar = new JButton("Adicionar aluno");
        JButton btnRemover = new JButton("Remover aluno");

        this.matriculaInputAluno = new JTextField(50);
        this.nomeInputAluno = new JTextField(50);
        this.diciplinasInputAluno = new JTextField(50);
        btnAdicionar.addActionListener(new AdicionarNovoAluno(this));
        btnRemover.addActionListener(new RemoverAluno(this));

        painel1.add(nome);
        painel1.add(nomeInputAluno);

        painel1.add(valor);
        painel1.add(matriculaInputAluno);

        painel1.add(descricao);
        painel1.add(diciplinasInputAluno);

        painel2.add(btnAdicionar);
        painel2.add(btnRemover);

        this.segundoPainelAlunos.add(painel1);
        this.segundoPainelAlunos.add(painel2);
    }

    private void drawSegundoPainelProfessores() {
        this.segundoPainelProfessores = new JPanel();

        this.segundoPainelProfessores.setLayout(new GridLayout(2, 0, 20, 0));

        JPanel painel1 = new JPanel();
        JPanel painel2 = new JPanel();

        painel1.setBorder(BorderFactory.createTitledBorder("PROFESSORES"));
        painel1.setLayout(new GridLayout(5, 2, 60, 30));
        painel2.setBorder(BorderFactory.createTitledBorder("DICIPLINAS"));
        painel2.setLayout(new GridLayout(5, 2, 60, 30));

        JLabel nome = new JLabel("Nome: ");
        JLabel valor = new JLabel("Matrícula ");
        JButton btnAdicionar = new JButton("Adicionar professor");
        JButton btnRemover = new JButton("Remover professor");

        this.matriculaInputProfessor = new JTextField(50);
        this.nomeInputProfessor = new JTextField(50);
        btnAdicionar.addActionListener(new AdicionarNovoProfessor(this));
        btnRemover.addActionListener(new RemoverProfessor(this));

        painel1.add(nome);
        painel1.add(nomeInputProfessor);

        JLabel descricao = new JLabel("Nome da diciplina: ");
        JLabel descricao2 = new JLabel("Código: ");
        JLabel descricao3 = new JLabel("Carga Horária: ");

        this.diciplinaNameInputProfessor = new JTextField(50);
        this.diciplinaCodeInputProfessor = new JTextField(50);
        this.diciplinaCHInputProfessor = new JTextField(50);

        painel1.add(valor);
        painel1.add(matriculaInputProfessor);

        painel1.add(btnAdicionar);
        painel1.add(btnRemover);

        painel2.add(descricao);
        painel2.add(this.diciplinaNameInputProfessor);

        painel2.add(descricao2);
        painel2.add(this.diciplinaCodeInputProfessor);

        painel2.add(descricao3);
        painel2.add(this.diciplinaCHInputProfessor);

        JButton btnAddDiciplina = new JButton("Vincular diciplina");
        JButton btnRemoveDiciplina = new JButton("Remove diciplina");

        btnAddDiciplina.addActionListener(new VincularDiciplinaProfessor(this));
        btnRemoveDiciplina.addActionListener(new DesvincularDiciplinaProfessor(this));
        painel2.add(btnAddDiciplina);
        painel2.add(btnRemoveDiciplina);

        this.segundoPainelProfessores.add(painel1);
        this.segundoPainelProfessores.add(painel2);
    }

    public TableDiciplinas getModelDiciplinas() {
        return this.modelDiciplinas;
    }

    public JTable getTableDiciplinass() {
        return this.tableDiciplinas;
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

    public JTextField getDiciplinaCHInputProfessor() {
        return this.diciplinaCHInputProfessor;
    }

    public JTextField getDiciplinaCodeInputProfessor() {
        return this.diciplinaCodeInputProfessor;
    }

    public JTextField getDiciplinaNameInputProfessor() {
        return this.diciplinaNameInputProfessor;
    }

    public JTextField getMatriculaInputProfessor() {
        return this.matriculaInputProfessor;
    }

    public List getAllProfessores() {
        return getModelProfessores().getList();
    }

    public List getAllDiciplinas() {

        List<Materia> listDisc = new ArrayList<>();

        List<Professor> listProf = getAllProfessores();

        for (Professor prof : listProf) {

            List<Materia> lis = prof.getListDiciplinas();
            for (Materia mat : lis) {
                listDisc.add(mat);
            }

        }

        return listDisc;
    }

    public boolean materiaValida(String code) {
        List<Materia> list = getAllDiciplinas();

        for (Materia mat : list) {
            if (mat.getCodigo().equals(code)) {
                return true;
            }
        }
        return false;

    }
    
    public void cleanFilds(){
        
    this.nomeInputAluno.setText("");
    this.matriculaInputAluno.setText("");
    this.diciplinasInputAluno.setText("");
    this.nomeInputProfessor.setText("");
    this.matriculaInputProfessor.setText("");
    this.diciplinaNameInputProfessor.setText("");
    this.diciplinaCodeInputProfessor.setText("");
    this.diciplinaCHInputProfessor.setText("");
        
    }
}
