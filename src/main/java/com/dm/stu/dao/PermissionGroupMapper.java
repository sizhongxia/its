package com.dm.stu.dao;

import com.dm.stu.domain.PermissionGroup;
import com.dm.stu.domain.PermissionGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermissionGroupMapper {
    long countByExample(PermissionGroupExample example);

    int deleteByExample(PermissionGroupExample example);

    int deleteByPrimaryKey(String permissionGroupId);

    int insert(PermissionGroup record);

    int insertSelective(PermissionGroup record);

    List<PermissionGroup> selectByExample(PermissionGroupExample example);

    PermissionGroup selectByPrimaryKey(String permissionGroupId);

    int updateByExampleSelective(@Param("record") PermissionGroup record, @Param("example") PermissionGroupExample example);

    int updateByExample(@Param("record") PermissionGroup record, @Param("example") PermissionGroupExample example);

    int updateByPrimaryKeySelective(PermissionGroup record);

    int updateByPrimaryKey(PermissionGroup record);
}