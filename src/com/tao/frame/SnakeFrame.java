package com.tao.frame;

import com.tao.panel.ButtonPanel;
import com.tao.panel.SnakePanel;

import javax.swing.*;

public class SnakeFrame extends JFrame {
    private SnakePanel snakePanel = new SnakePanel();
    private ButtonPanel buttonPanel = new ButtonPanel(snakePanel);
    public SnakeFrame() {
        initFrame();
        addComponent();
    }

    //初始化
    public void initFrame() {
        //设置窗口标题
        this.setTitle("贪吃蛇");
        //坐标大小
        this.setBounds(30, 40, 705, 715);
        //设置不能改变大小
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(null);
        //让snakePanel获取焦点
        this.snakePanel.setFocusable(true);
        this.snakePanel.requestFocus();
    }

    //添加其他组件
    public void addComponent() {
        this.add(snakePanel);
        this.add(buttonPanel);
    }

    /*public static void main(String[] args) {
        new SnakeFrame();
    }*/
}
