package com.aop.dao.impl;

import com.aop.bean.Weapon;
import com.aop.dao.WeaponDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 使用Spring-Jdbc实现WeaponDao接口
 */
@Service
//@Repository
public class WeaponDaoImpl_Spring_Jdbc implements WeaponDao {
    @Autowired //注入JdbcTemplate实例
    private JdbcTemplate jdbcTemplate;

    @Override
    public void update(int rid, int wid) {
        String sql = "update weapon set rid=? where wid=?";
        jdbcTemplate.update(sql, rid, wid);
    }

    @Override
    public Weapon getWeaponByWid(int wid) {
        String sql = "select wid,wname,rid from weapon where wid=?";
        Weapon weapon = jdbcTemplate.queryForObject(sql, new RowMapper<Weapon>() {
            @Override
            public Weapon mapRow(ResultSet rs, int i) throws SQLException {
                Weapon weapon = new Weapon();
                weapon.setWid(rs.getInt("wid"));
                weapon.setWname(rs.getString("wname"));
                weapon.setRid(rs.getInt("rid"));
                return weapon;
            }
        }, wid);
        return weapon;
    }

    @Override
    public Weapon getWeaponByRid(int rid) {
        String sql = "select wid,wname,rid from weapon where rid=?";
        Weapon weapon = jdbcTemplate.queryForObject(sql, new RowMapper<Weapon>() {

            @Override
            public Weapon mapRow(ResultSet rs, int i) throws SQLException {
                Weapon weapon = new Weapon();
                weapon.setWid(rs.getInt("wid"));
                weapon.setWname(rs.getString("wname"));
                weapon.setRid(rs.getInt("rid"));
                return weapon;
            }
        }, rid);
        return weapon;
    }

    @Override
    public int getMaxWid() {
        String sql = "select count(wname) from weapon";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public boolean weaponExists(int wid) {
        boolean exist = false;
        String sql = "select * from weapon where wid";
        Weapon weapon = jdbcTemplate.queryForObject(sql, new RowMapper<Weapon>() {
            @Override
            public Weapon mapRow(ResultSet rs, int i) throws SQLException {
                Weapon weapon = new Weapon();
                weapon.setWid(rs.getInt("wid"));
                weapon.setWname(rs.getString("wname"));
                weapon.setRid(rs.getInt("rid"));
                return weapon;
            }
        }, wid);
        if (weapon.getWname() != null) {
            exist = true;
        }
        return exist;
    }
}
