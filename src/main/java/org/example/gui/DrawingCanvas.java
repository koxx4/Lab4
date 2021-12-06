package org.example.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class DrawingCanvas extends JComponent{

    private final List<Shape> shapesToDraw;
    private final List<Color> shapesToDrawColors;

    public DrawingCanvas() {
        shapesToDraw = new ArrayList<>();
        shapesToDrawColors = new ArrayList<>();
        this.setOpaque(true);
        this.setBackground(Color.lightGray);
        this.setFocusable(true);
    }

    public void addNewShape(Shape shape, Color color){
        shapesToDraw.add(shape);
        shapesToDrawColors.add(color);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        for (int i = 0; i < shapesToDraw.size(); i++){
            g2d.setColor(shapesToDrawColors.get(i));
            g2d.fill(shapesToDraw.get(i));
        }
    }

}
