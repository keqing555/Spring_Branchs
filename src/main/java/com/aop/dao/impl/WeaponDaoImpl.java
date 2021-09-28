package com.aop.dao.impl;

import com.aop.bean.Weapon;
import com.aop.dao.WeaponDao;
import com.aop.util.MyJdbcFactory;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository     //创建dao层实例，放入到容器里
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

    @Override
    public int getMaxWid() {
        Connection connection=MyJdbcFactory.getConnection();
        String sql="select count(wid) from weapon";
        int max=0;
        try {
            PreparedStatement pstmt=connection.prepareStatement(sql);
            ResultSet resultSet = pstmt.executeQuery(sql);
            while(resultSet.next()){
                max = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return max;
    }

    @Override
    public boolean weaponExists(int wid) {
        boolean exist=false;
        Connection connection=MyJdbcFactory.getConnection();
        String sql="select * from weapon where wid=?";
        try {
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setInt(1,wid);
            exist = pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exist;
    }
}
