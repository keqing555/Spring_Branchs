package com.ssm.service;

import com.ssm.bean.Erole;
import com.ssm.dao.EroleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private EroleMapper eroleMapper;

    @Override
    public List<Erole> getAllRoles() {
        return eroleMapper.getAllRoles();
    }

    @Override
    public List<Erole> getRoleByEid(long eid) {
        return eroleMapper.getRoleByEid(eid);
    }
}
