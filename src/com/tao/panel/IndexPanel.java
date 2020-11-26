package com.tao.panel;

import com.tao.config.Config;
import com.tao.dao.UserDao;
import com.tao.frame.IndexFrame;
import com.tao.frame.SnakeFrame;
import com.tao.po.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IndexPanel extends JPanel implements ActionListener {

    JLabel label1 = new JLabel("用户名：");
    JLabel label2 = new JLabel("密码：");
    JTextField textField1 = new JTextField();
    JTextField textField2 = new JTextField();
    JButton button = new JButton("登录");

    private IndexFrame indexFrame;

    public IndexPanel(IndexFrame indexFrame) {
        init();
        this.indexFrame = indexFrame;
    }

    public void init() {
        this.setLayout(null);
        this.setBackground(Color.GREEN);
        this.setBounds(240,250,300,150);

        label1.setBounds(30,40,80,30);
        label2.setBounds(30,80,80,30);
        this.add(label1);
        this.add(label2);
        textField1.setBounds(110,40,100,30);
        textField2.setBounds(110,80,100,30);
        this.add(textField1);
        this.add(textField2);
        button.setBounds(220,80,60,30);
        this.add(button);
        button.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        UserDao dao = new UserDao();
        User user = dao.login(textField1.getText(), textField2.getText());
        if (user != null) {
            //保存用户信息
            Config.user = user;
            //让登录界面消失
            indexFrame.dispose();
            new SnakeFrame();
        } else {
            JOptionPane.showMessageDialog(null,"用户名或密码错误！");
            //System.out.println("用户名或密码错误！");
        }

    }
}
