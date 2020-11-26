package com.tao.panel;

import com.tao.dao.RankDao;
import com.tao.vo.RankVo;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class RankPanel extends JPanel{
    private JTable table;
    Font font = new Font("楷体", Font.BOLD, 18);

    public RankPanel() {
        initPanel();
        addComponents();
    }

    private void initPanel() {
        this.setBounds(0, 0, 700, 500);
        this.setLayout(null);

    }

    private void addComponents() {
        RankDao rankDao = new RankDao();
        List<RankVo> voList = rankDao.ranging();
        //列名
        Object[] columnNames = {"排名", "姓名","分数","日期"};
        //创建动态数组
        Object[][] rowData = new Object[voList.size()][4];
        for (int index = 0; index < voList.size(); index++) {
            rowData[index][0] = index + 1;
            rowData[index][1] = voList.get(index).getUsername();
            rowData[index][2] = voList.get(index).getScore();
            rowData[index][3] = voList.get(index).getDate();
        }
        table = new JTable(rowData,columnNames);
        table.setBounds(100,180,500,300);
        table.setFont(font);
        table.setRowHeight(40);
        //设置网格
        table.setShowGrid(false);
        //设置是否可用
        table.setEnabled(false);
        //设置透明背景
        table.setOpaque(false);
        this.add(table);

    }
}
