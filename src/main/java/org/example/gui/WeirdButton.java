package org.example.gui;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class WeirdButton extends JButton implements MouseListener {

    private final Random random = new Random();

    public WeirdButton() {
        super();
        addMouseListener(this);
    }

    public WeirdButton(String text) {
        super(text);
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        if (mouseEvent.getPoint().x <= (this.getSize().width * .5f)){
            changePositionRandomlyInBounds();
        }
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    private void changePositionRandomlyInBounds(){
        var parentSize = this.getParent().getSize();
        var thisSize = this.getSize();
        this.setBounds(
                random.nextInt(randomIntInRange(30, parentSize.width - thisSize.width)),
                random.nextInt(randomIntInRange(30, parentSize.height - thisSize.height)),
                thisSize.width,
                thisSize.height);
    }

    private int randomIntInRange(int min, int max){
        return random.nextInt((max - min) + 1) + min;
    }
}
