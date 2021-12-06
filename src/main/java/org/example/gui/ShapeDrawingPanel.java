package org.example.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class ShapeDrawingPanel extends JPanel{

    private final DrawingCanvas drawingCanvas;
    private final JScrollPane drawingCanvasScrollPane;
    private Class shapeToDraw = Rectangle2D.Double.class;
    private Color shapeToDrawColor = Color.red;


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
                drawingCanvas.requestFocusInWindow();
                if(e.getButton() == MouseEvent.BUTTON1){

                    if (shapeToDraw == Rectangle2D.Double.class)
                        drawingCanvas.addNewShape(new Rectangle2D.Double(e.getX() - 50, e.getY() - 25,100, 50 ),
                                shapeToDrawColor);
                    else if (shapeToDraw == Ellipse2D.Double.class)
                        drawingCanvas.addNewShape(new Ellipse2D.Double(e.getX() - 50, e.getY() - 25,100, 50 ),
                                shapeToDrawColor);

                    drawingCanvas.repaint();
                }

            }
        });

        drawingCanvas.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                System.out.println("k: " + e.getKeyCode());
                switch (e.getKeyCode()){
                    case KeyEvent.VK_K:
                        shapeToDraw = Rectangle2D.Double.class;
                        shapeToDrawColor = Color.red;
                        break;
                    case KeyEvent.VK_O:
                        shapeToDraw = Ellipse2D.Double.class;
                        shapeToDrawColor = new Color(117, 106, 182);
                        break;
                }

            }
        });

        drawingCanvasScrollPane.setMinimumSize(new Dimension(200,200));
        drawingCanvasScrollPane.getVerticalScrollBar().addAdjustmentListener( (e) -> drawingCanvasScrollPane.repaint() );
        drawingCanvasScrollPane.getHorizontalScrollBar().addAdjustmentListener( (e) -> drawingCanvasScrollPane.repaint() );

        this.add(drawingCanvasScrollPane, BorderLayout.CENTER);
    }


}
