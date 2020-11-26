package com.tao.panel;

import com.tao.config.Config;
import com.tao.po.Food;
import com.tao.po.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 监听事件
 * 1.实现ActionListener接口
 * 2.实现抽象方法
 * 3.和相应的事件绑定
 *
 * ActionListener:按钮点击
 * KeyListener:键盘点击
 *
 * 获取焦点
 */
public class SnakePanel extends JPanel implements KeyListener {

    //食物
    public Food food = new Food();
    //蛇
    public Snake snake = new Snake(food);
    private SnakeThread snakeThread = new SnakeThread();
    private Font font = new Font("黑体",Font.BOLD,30);

    public SnakePanel() {
        initPane();
        addComponent();
        //启动线程
        snakeThread.start();
    }

    //初始化操作
    private void initPane() {
        //
        this.setSize(700, 640);
        //
        this.setBackground(Color.GREEN);
        //绑定
        this.addKeyListener(this);
    }

    //重写父类中的方法
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //画笔
        g.setColor(Color.GRAY);
        //设置字体
        g.setFont(font);
        //绘制文字
        g.drawString("Score:"+Config.score,40,40);
        //画线,横线
        for (int i = 0; i < Config.ROWS; i++) {
            g.drawLine(0, Config.SPAN * i, Config.SPAN * Config.COLS, Config.SPAN * i);
        }
        //竖线
        for (int i = 0; i < Config.COLS; i++) {
            g.drawLine(Config.SPAN * i, 0, Config.SPAN * i, Config.SPAN * Config.ROWS);
        }

        //画食物
        food.draw(g);
        //画蛇
        snake.draw(g);
        //蛇移动
        snake.move();
        //吃食物
        snake.eatOrnOT();
        //死亡检测
        snake.deadCheck();
    }

    //添加其他组件
    private void addComponent() {
        //添加食物、分数、🐍

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //点击按键调用的方法
    //点击键盘上的按键，就会触发该方法，并且将键盘点击事件以参数的形式传递到
    @Override
    public void keyPressed(KeyEvent e) {
        //点击w,s,a,d实现Snake移动
        this.snake.dirControl(e);
        if (Config.islive) {
            this.repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    //内部类
    class SnakeThread extends Thread {
        @Override
        public void run() {
            super.run();
                while (true) {
                    try {
                        Thread.sleep(Config.speed);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //重新绘制SnakePanel
                    if (Config.islive && Config.isgone) {

                        repaint();
                    }
                }
        }
    }
}
