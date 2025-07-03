/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.unesp.frontend.thales.hotel.util;

import java.awt.Component;
import java.awt.Container;
import java.awt.Window;
import java.lang.reflect.Constructor;
import java.util.function.Supplier;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author eteixeira
 */
public class AtualizaUtil {

    public void atualizar() {
        for (Window window : Window.getWindows()) {
            if (window.isVisible() && window instanceof JFrame frame) {
                Container content = frame.getContentPane();
                atualizarComponentes(content);
                content.revalidate();
                content.repaint();
            }
        }
    }

    private void atualizarComponentes(Container container) {
        Component[] components = container.getComponents();

        for (int i = 0; i < components.length; i++) {
            Component comp = components[i];

            if (comp instanceof JPanel panel) {
                try {
                    // tenta criar uma nova instância da mesma classe
                    Class<?> clazz = panel.getClass();
                    Constructor<?> ctor = clazz.getDeclaredConstructor();
                    ctor.setAccessible(true); // caso o construtor seja protegido
                    JPanel novoPainel = (JPanel) ctor.newInstance();

                    container.remove(panel);
                    container.add(novoPainel, i); // adiciona no mesmo índice
                } catch (Exception e) {
                    System.err.println("Erro ao atualizar painel: " + comp.getClass().getSimpleName());
                    e.printStackTrace();
                }
            }

            if (comp instanceof Container child) {
                atualizarComponentes(child); // recursivamente atualiza os filhos
            }
        }
    }

}
