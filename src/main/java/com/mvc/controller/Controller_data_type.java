package com.mvc.controller;

import com.mvc.bean.Role;
import com.mvc.bean.Weapon;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("data")
public class Controller_data_type {
    /**
     * 返回任意数据类型转为json格式字符串
     */
    @RequestMapping("json")
    @ResponseBody   //设置响应体
    public Role json(){
        Role role=new Role();
        role.setRname("刻晴");
        role.setAge(18);
        String[] hobbies={"金丝虾球","璃月采矿有加成"};
        role.setHobbies(hobbies);   //设置String数组
        Weapon weapon=new Weapon();
        weapon.setWname("匣里龙吟");
        weapon.setType("单手剑");
        role.setWeapon(weapon);
        List<Weapon> list=new ArrayList<>();
        list.add(weapon);
        return role;
    }
}
