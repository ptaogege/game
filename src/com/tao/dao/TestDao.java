package com.tao.dao;

import com.tao.po.Rank;
import com.tao.po.User;
import org.junit.Test;

import java.sql.SQLException;

public class TestDao {
    @Test
    public void test1() throws SQLException {
        UserDao dao = new UserDao();
        User user = dao.login("zhangsan", "123");
        System.out.println(user);
    }

    @Test
    public void test2() {
        RankDao dao = new RankDao();
        Rank rank = new Rank();
        rank.setScore(20);
        rank.setDate("2020-9-20");
        rank.setUserId(4);
        int s = dao.add(rank);
        System.out.println(s);
    }
}
