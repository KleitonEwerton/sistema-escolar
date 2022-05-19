/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.sistema;

import static com.kleitonewerton.sistema.Utils.bemVindo;
import com.kleitonewerton.sistema.views.Tela;

/**
 *
 * @author KleitonEwerton
 */
public class Sistema {

    public static void main(String[] args) {

        bemVindo();
        Tela screen = new Tela();
        screen.draw();

    }

}
