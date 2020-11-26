package com.tao.frame;

import com.tao.panel.RankPanel;

import javax.swing.*;
import java.awt.*;

public class RankFrame extends JFrame {
    private RankPanel rankPanel = new RankPanel();

    public RankFrame() {
        init();
        addComponents();
    }

    public void init() {
        this.setLayout(null);
        this.setTitle("排名");
        this.setBackground(Color.BLUE);
        this.setBounds(200, 200, 500, 400);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public void addComponents() {
        this.add(rankPanel);
    }
    public static void main(String[] args) {
        new RankFrame();
    }
}
