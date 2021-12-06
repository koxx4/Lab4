package org.example;


import org.example.gui.MainFrame;

import javax.swing.*;
import java.awt.*;

public class App {

    public static void main( String[] args ) {
        runApp();
    }

    public static void runApp(){
        System.setProperty("awt.useSystemAAFontSettings","on");
        System.setProperty("swing.aatext", "true");
        SwingUtilities.invokeLater( () -> {
            try {
                JFrame frame = new MainFrame();
            }
            catch (HeadlessException exception){
                System.err.println("You don't have a screen, ouch...");
            }
        });
    }

}
