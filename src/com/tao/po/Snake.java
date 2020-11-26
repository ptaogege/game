package com.tao.po;

import com.tao.config.Config;
import com.tao.dao.RankDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 蛇类
 */
public class Snake {
    private Node head;
    private Node body;
    private Node tail;
    private Food food;

    public Snake(Food food) {
        this.food = food;

        //创建蛇初始三个节点，让其在同一行
        head = new Node(17, 11, Config.R);
        body = new Node(16, 11, Config.R);
        tail = new Node(15, 11, Config.R);
        //让三个节点关联，创建一个双向链表
        head.pre = null;
        head.next = body;
        body.pre = head;
        body.next = tail;
        tail.pre = body;
        tail.next = null;

    }

    //画蛇
    public void draw(Graphics g) {
        //画每个节点
        for (Node n = head; n != null; n = n.next) {

            n.draw(g);
        }
    }

    public void move() {
        //添加头
        addHead();
        //去掉尾
        removeTail();

    }

    private void addHead() {
        //判断当前往那个方向走，然后在头的相应位置添加一个元素-->头的 移动方向
        Node node = null;
        switch (this.head.getDir()) {

            case Config.U:
                node = new Node(this.head.getCol(), this.head.getRow() - 1, this.head.getDir());
                break;
            case Config.D:
                node = new Node(this.head.getCol(), this.head.getRow() + 1, this.head.getDir());
                break;
            case Config.L:
                node = new Node(this.head.getCol() - 1, this.head.getRow(), this.head.getDir());
                break;
            case Config.R:
                node = new Node(this.head.getCol() + 1, this.head.getRow(), this.head.getDir());
                break;
        }

        node.pre = null;
        node.next = head;
        head.pre = node;
        head = node;

    }

    private void removeTail() {
        Node temp = tail;
        tail = tail.pre;
        tail.next = null;
        temp.pre = null;
    }

    //通过键盘控制蛇的移动
    public void dirControl(KeyEvent e) {
        //不能向相反的方向转换方向
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                if (!this.head.getDir().equals(Config.D)) {
                    this.head.setDir(Config.U);
                }
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                if (!this.head.getDir().equals(Config.U)) {
                    this.head.setDir(Config.D);
                }
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                if (!this.head.getDir().equals(Config.R)) {
                    this.head.setDir(Config.L);
                }
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                if (!this.head.getDir().equals(Config.L)) {
                    this.head.setDir(Config.R);
                }
                break;

        }
    }

    /**
     * 吃食物检测
     *
     * 吃到食物--头和食物坐标重回
     */
    public void eatOrnOT() {
        //
        if (this.getHeadRectangle().contains(this.food.getFoodRectangle())) {
            Config.speed = (int) (Config.speed/1.1);
            Config.score++;
            this.addHead();
            this.food.reGen();
        }
    }

    //获取head所在的矩形
    public Rectangle getHeadRectangle() {
        return new Rectangle(this.head.getCol()*Config.SPAN,
                this.head.getRow()*Config.SPAN,
                Config.SPAN,
                Config.SPAN);
    }

    /**
     * 死亡检测
     * 头碰到边界
     * 头碰到身体
     */

    public void deadCheck() {
        //head碰到边界
        if (this.head.getCol() < 0 ||
                this.head.getCol() > Config.COLS ||
                this.head.getRow() < 0 ||
                this.head.getRow() > Config.ROWS) {
            Config.islive = false;
            //JOptionPane.showMessageDialog(null, "你死了", "game over", JOptionPane.PLAIN_MESSAGE);
            return;
        }
        //head碰到body,node表示头之后的所有节点
        for (Node node = head.next; node != null; node = node.next) {
            Rectangle nodeRect = new Rectangle(node.getCol() * Config.SPAN,
                    node.getRow() * Config.SPAN,
                    Config.SPAN,
                    Config.SPAN);
            if (this.getHeadRectangle().contains(nodeRect)) {
                Config.islive = false;
                return;
            }
        }
    }

    /**
     * 保存分数
     */
    public void saveScore() {
        RankDao rankDao = new RankDao();
        Rank rank = new Rank();
        rank.setScore(Config.score);
        rank.setUserId(Config.user.getId());
        //
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String s = format.format(date);
        rank.setDate(s);
        rankDao.add(rank);
    }
}
