package com.szpnr.plsup.mybatis.dao;

import com.szpnr.plsup.mybatis.model.PlsupLocation;
import com.szpnr.plsup.mybatis.model.PlsupLocationCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlsupLocationMapper {
    long countByExample(PlsupLocationCriteria example);

    int deleteByExample(PlsupLocationCriteria example);

    int deleteByPrimaryKey(Short locationId);

    int insert(PlsupLocation record);

    int insertSelective(PlsupLocation record);

    List<PlsupLocation> selectByExample(PlsupLocationCriteria example);

    PlsupLocation selectByPrimaryKey(Short locationId);

    int updateByExampleSelective(@Param("record") PlsupLocation record, @Param("example") PlsupLocationCriteria example);

    int updateByExample(@Param("record") PlsupLocation record, @Param("example") PlsupLocationCriteria example);

    int updateByPrimaryKeySelective(PlsupLocation record);

    int updateByPrimaryKey(PlsupLocation record);
}