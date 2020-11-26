package com.tao.dao;

import com.tao.po.Rank;
import com.tao.util.JdbcUtils;
import com.tao.vo.RankVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RankDao {
    public int add(Rank rank) {
        Connection conn = null;
        PreparedStatement pstm = null;
        int result = 0;
        String sql = "insert into rank(score,date,userId) values(?,?,?)";
        try {
            conn = JdbcUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, rank.getScore());
            pstm.setString(2, rank.getDate());
            pstm.setInt(3,rank.getUserId());
            result = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pstm.close();
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return result;
    }

    /**
     *
     */
    public List<RankVo> ranging() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        List<RankVo> ranks = null;
        String sql = "select username,score,date from rank r,user u where r.userId=u.id order by score desc LIMIT 5";
        try {
            conn = JdbcUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            resultSet = pstm.executeQuery();
            ranks = new ArrayList<>();
            while (resultSet.next()) {
                RankVo rankVo = new RankVo(resultSet.getString(1),resultSet.getInt(2),resultSet.getString(3));
                ranks.add(rankVo);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                resultSet.close();
                pstm.close();
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return ranks;
    }
}
