package com.dm.stu.dao;

import com.dm.stu.domain.PGroupMenu;
import com.dm.stu.domain.PGroupMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PGroupMenuMapper {
    long countByExample(PGroupMenuExample example);

    int deleteByExample(PGroupMenuExample example);

    int deleteByPrimaryKey(@Param("permissionGroupId") String permissionGroupId, @Param("menuId") String menuId);

    int insert(PGroupMenu record);

    int insertSelective(PGroupMenu record);

    List<PGroupMenu> selectByExample(PGroupMenuExample example);

    int updateByExampleSelective(@Param("record") PGroupMenu record, @Param("example") PGroupMenuExample example);

    int updateByExample(@Param("record") PGroupMenu record, @Param("example") PGroupMenuExample example);
}