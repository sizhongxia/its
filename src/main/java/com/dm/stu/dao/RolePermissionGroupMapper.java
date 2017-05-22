package com.dm.stu.dao;

import com.dm.stu.domain.RolePermissionGroup;
import com.dm.stu.domain.RolePermissionGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolePermissionGroupMapper {
    long countByExample(RolePermissionGroupExample example);

    int deleteByExample(RolePermissionGroupExample example);

    int deleteByPrimaryKey(@Param("roleId") String roleId, @Param("permissionGroupId") String permissionGroupId);

    int insert(RolePermissionGroup record);

    int insertSelective(RolePermissionGroup record);

    List<RolePermissionGroup> selectByExample(RolePermissionGroupExample example);

    int updateByExampleSelective(@Param("record") RolePermissionGroup record, @Param("example") RolePermissionGroupExample example);

    int updateByExample(@Param("record") RolePermissionGroup record, @Param("example") RolePermissionGroupExample example);
}