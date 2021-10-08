package com.ssm.dao;

import com.ssm.bean.Efunction;
import com.ssm.bean.EfunctionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EfunctionMapper {
    long countByExample(EfunctionExample example);

    int deleteByExample(EfunctionExample example);

    int deleteByPrimaryKey(Long fid);

    int insert(Efunction record);

    int insertSelective(Efunction record);

    List<Efunction> selectByExample(EfunctionExample example);

    Efunction selectByPrimaryKey(Long fid);

    int updateByExampleSelective(@Param("record") Efunction record, @Param("example") EfunctionExample example);

    int updateByExample(@Param("record") Efunction record, @Param("example") EfunctionExample example);

    int updateByPrimaryKeySelective(Efunction record);

    int updateByPrimaryKey(Efunction record);
}