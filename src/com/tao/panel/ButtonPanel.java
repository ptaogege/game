package com.tao.panel;

import com.tao.config.Config;
import com.tao.frame.RankFrame;
import com.tao.po.Food;
import com.tao.po.Snake;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//暂停、开始
public class ButtonPanel extends JPanel implements ActionListener{
    private JButton btn_pause = new JButton("暂停游戏");
    private JButton btn_continue = new JButton("继续游戏");
    private JButton btn_restart = new JButton("重新开始");
    private JButton btn_rank = new JButton("游戏排行");
    private SnakePanel snakePanel;

    public ButtonPanel(SnakePanel snakePanel) {
        this.snakePanel = snakePanel;
        init();
        addComponent();
    }

    public void init() {
        this.setBounds(0, 643, 700, 70);
        btn_continue.addActionListener(this);
        btn_pause.addActionListener(this);
        btn_rank.addActionListener(this);
        btn_restart.addActionListener(this);
    }

    public void addComponent() {
        this.add(btn_pause);
        this.add(btn_continue);
        this.add(btn_restart);
        this.add(btn_rank);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //暂停
        if (e.getSource() == btn_pause) {
            pauseGame();
        }
        //继续
        if (e.getSource() == btn_continue) {
            continueGame();
            //重新获取焦点
            this.snakePanel.setFocusable(true);
            this.snakePanel.requestFocus();
        }
        //重新开始
        if (e.getSource() == btn_restart) {
            restartGame();
            //重新获取焦点
            this.snakePanel.setFocusable(true);
            this.snakePanel.requestFocus();
        }
        //显示排行
        if (e.getSource() == btn_rank) {
            showRank();
        }
    }

    //排行
    private void showRank() {
        Config.isgone = false;
        new RankFrame();
    }

    //暂停
    public void pauseGame() {
        Config.isgone = false;
    }

    //继续
    public void continueGame() {
        Config.isgone = true;
    }


    //重新开始
    public void restartGame() {
        Config.reload();
        snakePanel.food = new Food();
        snakePanel.snake = new Snake(snakePanel.food);
    }
}
