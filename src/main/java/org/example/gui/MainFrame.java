package org.example.gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private final CatchButtonPanel catchButtonPanel;
    private final ShapeDrawingPanel shapeDrawingPanel;
    private final JMenuBar menuBar;
    private JPanel activePanel;

    public MainFrame() throws HeadlessException {
        super("Lab 4 program");

        catchButtonPanel = new CatchButtonPanel();
        shapeDrawingPanel = new ShapeDrawingPanel();
        menuBar = new JMenuBar();

        initializeComponentsProperties();
        initializeMenuBar();
        switchToPanel(catchButtonPanel);
    }

    private void initializeComponentsProperties(){
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(500,600));
        this.setMinimumSize(new Dimension(500,500));

        this.setJMenuBar(this.menuBar);
    }

    private void initializeMenuBar(){
        JMenu changePanelMenu = new JMenu("Change mode");
        JMenuItem catchButton = new JMenuItem("CatchButton");
        JMenuItem canvas = new JMenuItem("Canvas");

        catchButton.addActionListener((e) -> switchToPanel(catchButtonPanel));
        canvas.addActionListener((e) -> switchToPanel(shapeDrawingPanel));

        changePanelMenu.add(catchButton);
        changePanelMenu.add(canvas);

        menuBar.add(changePanelMenu);
    }

    private void switchToPanel(JPanel panel) {
        if (activePanel == panel)
            return;

        if(activePanel != null)
            this.remove(activePanel);

        this.add(panel, BorderLayout.CENTER);
        this.validate();
        this.repaint();
        this.activePanel = panel;
    }
}
