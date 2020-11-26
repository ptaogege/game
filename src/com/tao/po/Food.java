package com.tao.po;

import com.tao.config.Config;

import javax.security.auth.login.ConfigurationSpi;
import java.awt.*;
import java.util.Random;

/**
 * 食物类,随机生成在一个方格空间内
 */
public class Food {
    private int col;  //列--横坐标
    private int row;  //行--纵坐标

    //构造方法
    public Food() {
        this.reGen();
    }

    //重新生成食物
    public void reGen() {
        this.col = new Random().nextInt(Config.COLS);
        this.row = new Random().nextInt(Config.ROWS);
    }

    public void draw(Graphics g) {
        //食物颜色
        g.setColor(Color.RED);
        //画矩形
        g.fillRect(Config.SPAN * col, Config.SPAN * row, Config.SPAN, Config.SPAN);

    }

    //获取食物所造的矩形
    public Rectangle getFoodRectangle() {
       return new Rectangle(this.col*Config.SPAN,
                this.row*Config.SPAN,
                Config.SPAN,
                Config.SPAN);
    }
}
