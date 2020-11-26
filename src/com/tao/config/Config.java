package com.tao.config;

import com.tao.po.User;

//常量配置
public class Config {
	
	public static final int ROWS = 32;//行
	public static final int COLS = 35;//列
	public static final int SPAN = 20;//间距
	
	public static final String U = "u";//方向-上
	public static final String D = "d";//方向-下
	public static final String L = "l";//方向-左
	public static final String R = "r";//方向-右
	
	public static boolean islive = true;//死亡检测的标识
	public static int speed = 400;//速度，间隔多少毫秒移动一次
	public static boolean valid = false;//当前的 单位时间内 有无 有效按键事件false代表没有
	public static boolean isgone = true;//暂停 继续
	public static int score = 0;//得分
	public static User user;//当前登录人

	
	//控制条件初始化
	public static void reload() {
		islive = true;
		valid = false;
		score = 0;
		speed = 400;
		isgone = true;
	}
}
