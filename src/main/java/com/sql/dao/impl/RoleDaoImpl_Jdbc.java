package com.sql.dao.impl;

import com.sql.bean.Role;
import com.sql.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository //注解在三层架构中的dao层类上，作用创建dao层类实例，并放到容器中；
//使用spring-jdbc实现dao层接口操作数据库
public class RoleDaoImpl_Jdbc implements RoleDao {
    //注解在成员变量位置上，作用给成员变量设置初始值（根据类型从容器中取出实例注入到属性值中），
    // 要求自动注入实例时，容器中该类型的实例只能有一个；
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //getter，setter方法
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertRole(Role role) {
        String sql = "insert into role(rname,area,age,sex,star,elemental_force) values(?,?,?,?,?)";
        jdbcTemplate.update(sql, role.getRname(), role.getArea(), role.getAge(), role.getSex(), role.getStar(), role.getElementalForce());
    }

    @Override
    public void deleteRole(int rid) {
        String sql = "delete from role where rid=?";
        jdbcTemplate.update(sql, rid);
    }

    @Override
    public void updateRole(Role role) {
        String sql = "update role set rname=?,area=?,age=?,sex=?,star=?,elemental_force=? where rid=?";
        jdbcTemplate.update(sql, role.getRname(), role.getArea(), role.getAge(), role.getSex(), role.getStar(), role.getElementalForce(), role.getRid());
    }

    @Override
    public Role selectRoleByRid(int rid) {
        //星号拿不到字段不一样的值
        String sql = "select * from role where rid=?";
        Role role = jdbcTemplate.queryForObject(sql, new RowMapper<Role>() {
            @Override
            public Role mapRow(ResultSet rs, int row) throws SQLException {
                Role role = new Role();
                role.setRid(rs.getInt("rid"));
                role.setRname(rs.getString("rname"));
                role.setArea(rs.getString("area"));
                role.setStar(rs.getString("star"));
                role.setAge(rs.getInt("age"));
                role.setSex(rs.getString("sex"));
                role.setElementalForce(rs.getString("elemental_force"));
                return role;
            }
        }, rid);
        return role;
    }

    @Override
    public List<Role> selectAllRole() {
        //写星号拿不到字段不一样的值
        String sql = "select * from role";
        List<Role> list = jdbcTemplate.query(sql, (rs, row) -> {
            Role role = new Role();
            role.setRid(rs.getInt("rid"));
            role.setRname(rs.getString("rname"));
            role.setArea(rs.getString("area"));
            role.setStar(rs.getString("star"));
            role.setAge(rs.getInt("age"));
            role.setSex(rs.getString("sex"));
            role.setElementalForce(rs.getString("elemental_force"));
            return role;
        });
        return list;
    }
}
