package org.example.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class CatchButtonPanel extends JPanel {

    private final JButton normalButton;
    private final WeirdButton runningButton;

    public CatchButtonPanel() {
        super();
        this.setLayout(null);
        this.setOpaque(true);
        this.setBackground(Color.lightGray);

        this.normalButton = new JButton("Normal");
        this.runningButton = new WeirdButton("Weird");

        initializeButtonProperties();
    }

    private void initializeButtonProperties(){
        this.normalButton.setBounds(100,100, 100,30);
        this.runningButton.setBounds(300,100, 100,30);

        this.add(normalButton);
        this.add(runningButton);
    }

}
