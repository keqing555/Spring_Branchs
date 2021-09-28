package com.aop.dao.impl;

import com.aop.bean.Weapon;
import com.aop.dao.WeaponDao;
import com.aop.util.MyJdbcFactory;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class WeaponDaoImpl implements WeaponDao {
    @Override
    public void update(int rid,int wid) {
        Connection connection = MyJdbcFactory.getConnection();
        String sql = "update weapon set rid=? where wid=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,rid);
            pstmt.setInt(2, wid);
            pstmt.executeUpdate();
            MyJdbcFactory.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Weapon getWeaponByWid(int wid) {
        Weapon weapon = new Weapon();
        //获取连接
        Connection connection = MyJdbcFactory.getConnection();
        String sql = "select wid,wname,rid from weapon where wid=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, wid);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                weapon.setRid(rs.getInt("rid"));
                weapon.setWname(rs.getString("wname"));
                weapon.setWid(rs.getInt("wid"));
            }
            rs.close();
            MyJdbcFactory.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return weapon;
    }

    @Override
    public Weapon getWeaponByRid(int rid) {
        Weapon weapon = new Weapon();
        //获取连接
        Connection connection = MyJdbcFactory.getConnection();
        String sql = "select wid,wname,rid from weapon where rid=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, rid);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                weapon.setRid(rs.getInt("rid"));
                weapon.setWname(rs.getString("wname"));
                weapon.setWid(rs.getInt("wid"));
            }
            rs.close();
            MyJdbcFactory.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return weapon;
    }
}
