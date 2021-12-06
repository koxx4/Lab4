package org.example.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class CatchButtonPanel extends JPanel {

    private final JButton normalButton;
    private final JButton runningButton;
    private final Random random;

    public CatchButtonPanel() {
        super();
        this.setLayout(null);
        this.setOpaque(true);
        this.setBackground(Color.lightGray);

        this.normalButton = new JButton("Normal");
        this.runningButton = new JButton("Weird");
        this.random = new Random();

        this.runningButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {

                if (e.getPoint().x <= runningButton.getSize().width/2){
                    changeWeirdButtonPosition();
                }

            }
        });


        initializeButtonProperties();
    }

    private void initializeButtonProperties(){
        this.normalButton.setBounds(100,100, 100,30);
        this.runningButton.setBounds(300,100, 100,30);


        this.add(normalButton);
        this.add(runningButton);
    }

    private void changeWeirdButtonPosition(){
        var btnSize = runningButton.getSize();
        this.runningButton.setBounds(
                random.nextInt(randomIntInRange(50, this.getSize().width - btnSize.width)),
                random.nextInt(randomIntInRange(50, this.getSize().height - btnSize.height)),
                btnSize.width,
                btnSize.height);
    }

    private int randomIntInRange(int min, int max){
        return this.random.nextInt((max - min) + 1) + min;
    }


}
