package org.example.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;

public class ShapeDrawingPanel extends JPanel{

    private final DrawingCanvas drawingCanvas;
    private final JScrollPane drawingCanvasScrollPane;


    public ShapeDrawingPanel() {
        super();
        this.setLayout(new BorderLayout());
        this.setMinimumSize(new Dimension(150,150));


        this.drawingCanvas = new DrawingCanvas();
        this.drawingCanvasScrollPane = new JScrollPane(drawingCanvas);

        this.initializeComponents();
    }

    private void initializeComponents(){
        drawingCanvas.setMinimumSize(new Dimension(300,300));
        drawingCanvas.setPreferredSize(new Dimension(2000,2000));
        drawingCanvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                if(e.getButton() == MouseEvent.BUTTON1){
                    drawingCanvas.addNewShape(new Rectangle2D.Double(e.getX() - 25, e.getY() - 25, 50, 50), Color.RED);
                    drawingCanvas.repaint();
                }

            }
        });

        drawingCanvasScrollPane.setMinimumSize(new Dimension(200,200));
        drawingCanvasScrollPane.getVerticalScrollBar().addAdjustmentListener( (e) -> drawingCanvasScrollPane.repaint() );
        drawingCanvasScrollPane.getHorizontalScrollBar().addAdjustmentListener( (e) -> drawingCanvasScrollPane.repaint() );

        this.add(drawingCanvasScrollPane, BorderLayout.CENTER);
    }


}
