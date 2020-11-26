package com.tao.po;

import com.tao.config.Config;

import java.awt.*;

/**
 *蛇身
 */
public class Node {
    private int col;  //节点所在的列--横坐标
    private int row;  //节点所在的行--纵坐标
    private String dir;  //方向
    public Node pre;  //前一个元素
    public Node next;  //后一个元素

    public Node(int col, int row, String dir) {
        this.col = col;
        this.row = row;
        this.dir = dir;
    }

    public Node() {
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public void draw(Graphics g) {
        //判断是否是头节点
        if (this.pre == null) {
            g.setColor(Color.YELLOW);
        } else {
            g.setColor(Color.BLUE);
        }
        g.fillOval(col * Config.SPAN, row * Config.SPAN, Config.SPAN, Config.SPAN);
    }
}
