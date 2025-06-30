/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.com.unesp.frontend.thales.hotel;

import br.com.unesp.frontend.thales.hotel.forms.init.Inicio;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.util.Locale;
import javax.swing.UIManager;

/**
 *
 * @author Eduks
 */
public class ThalesHotel {

    public static void main(String[] args) {
        try{
            
            Locale.setDefault(new Locale("pt", "BR"));
            
            UIManager.setLookAndFeel(new FlatMacLightLaf());
            Inicio inicio = new Inicio();
            inicio.setVisible(true);
            inicio.setResizable(false);
        }catch(Exception e){
            System.err.println("Ocorreu um erro ao tentar inicializar o tema");
        }
    }
}
