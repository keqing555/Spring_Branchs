package com.psi.util;

import com.psi.dao.impl.RoleDaoImpl;
import org.springframework.beans.factory.FactoryBean;

public class MyFactory implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new RoleDaoImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
