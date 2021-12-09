package org.example.gui;

import javax.swing.*;
import java.awt.*;

public class CatchButtonPanel extends JPanel {

    private final JButton normalButton;
    private final WeirdButton runningButton;
    private final Point weirdButtonInitialPosition;

    public CatchButtonPanel() {
        super();
        this.setLayout(null);
        this.setOpaque(true);
        this.setBackground(Color.lightGray);

        this.normalButton = new JButton("Normal");
        this.runningButton = new WeirdButton("Weird");
        this.weirdButtonInitialPosition = new Point(300,100);

        initializeButtonProperties();
    }

    private void initializeButtonProperties(){
        this.normalButton.setBounds(100,100, 100,30);
        this.runningButton.setBounds(weirdButtonInitialPosition.x, weirdButtonInitialPosition.y, 100,30);

        this.runningButton.addActionListener((e) -> {
            runningButton.setLocation(weirdButtonInitialPosition);
            this.validate();
            this.repaint();
        });

        this.add(normalButton);
        this.add(runningButton);
    }

}
