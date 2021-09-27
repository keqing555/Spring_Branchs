package com.sql.dao.impl;

import com.sql.bean.Role;
import com.sql.dao.RoleDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;


//实现dao层接口
public class RoleDaoImpl implements RoleDao {
    //queryRunner由spring初始化
    private QueryRunner queryRunner;

    //getter，setter方法
    public QueryRunner getQueryRunner() {
        return queryRunner;
    }

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    @Override
    public void insertRole(Role role) {
        String sql = "insert into role(rname,area,age,sex,star,elemental_force) values(?,?,?,?,?)";
        try {
            queryRunner.update(sql, role.getRname(), role.getArea(), role.getAge(), role.getSex(), role.getStar(), role.getElementalForce());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRole(int rid) {
        String sql = "delete from role where rid=?";
        try {
            queryRunner.update(sql, rid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateRole(Role role) {
        String sql = "update role set rname=?,area=?,age=?,sex=?,star=?,elemental_force=? where rid=?";
        try {
            queryRunner.update(sql, role.getRname(), role.getArea(), role.getAge(), role.getSex(), role.getStar(), role.getElementalForce(), role.getRid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Role selectRoleByRid(int rid) {
        //星号拿不到字段不一样的值
        String sql = "select * from role where rid=?";
        Role role = null;
        try {
            role = queryRunner.query(sql, new BeanHandler<>(Role.class), rid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public List<Role> selectAllRole() {
        //写星号拿不到字段不一样的值
        String sql = "select * from role";
        List<Role> list = null;
        try {
            list = queryRunner.query(sql, new BeanListHandler<>(Role.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
