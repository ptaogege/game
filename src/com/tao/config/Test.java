package com.tao.config;

import java.util.Random;

public class Test {
    /**
     * 随机生成 m--n
     * 化为 1--(n-(m-1))
     * Math.random()*(n-(m-1)) + m
     * @param args
     */
    public static void main(String[] args) {
        /*for (int i = 0; i < 50; i++) {
            int num = (int) (Math.random() * 60 + 31);
            System.out.println(num);
        }*/

        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            System.out.println(random.nextInt(20)+1);  //1--20
        }
    }
}
