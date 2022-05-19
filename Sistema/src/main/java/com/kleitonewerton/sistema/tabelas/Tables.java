/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.kleitonewerton.sistema.tabelas;

import java.util.List;

/**
 *
 * @author KleitonEwerton
 */
public interface Tables {

    void removeObj(int indexLinha);

    void atualizarTabela();

    List getList();

    boolean contains(String value);

}
