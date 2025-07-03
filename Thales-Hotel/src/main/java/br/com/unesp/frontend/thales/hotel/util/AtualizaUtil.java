/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.unesp.frontend.thales.hotel.util;

import java.awt.Window;

/**
 *
 * @author eteixeira
 */
public class AtualizaUtil {

    public void atualizar() {
        for (Window window : Window.getWindows()) {
            if (window.isVisible()) {
                window.repaint();
                window.revalidate();
            }
        }

    }

}
