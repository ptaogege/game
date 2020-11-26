package com.tao.frame;

import com.tao.panel.IndexPanel;
import com.tao.util.JDBCUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IndexFrame extends JFrame {

    public IndexPanel indexPanel = new IndexPanel(this);


    public IndexFrame() {
        init();
        addComponent();
    }

    public void init() {
        this.setLayout(null);

        this.setTitle("登录");
        this.setBounds(200, 200, 600, 500);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void addComponent() {
        this.add(indexPanel);
    }

    public static void main(String[] args) {
        new IndexFrame();
    }


}
