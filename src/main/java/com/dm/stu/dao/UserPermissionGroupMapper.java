package com.dm.stu.dao;

import com.dm.stu.domain.UserPermissionGroup;
import com.dm.stu.domain.UserPermissionGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserPermissionGroupMapper {
    long countByExample(UserPermissionGroupExample example);

    int deleteByExample(UserPermissionGroupExample example);

    int deleteByPrimaryKey(@Param("userId") String userId, @Param("permissionGroupId") String permissionGroupId);

    int insert(UserPermissionGroup record);

    int insertSelective(UserPermissionGroup record);

    List<UserPermissionGroup> selectByExample(UserPermissionGroupExample example);

    int updateByExampleSelective(@Param("record") UserPermissionGroup record, @Param("example") UserPermissionGroupExample example);

    int updateByExample(@Param("record") UserPermissionGroup record, @Param("example") UserPermissionGroupExample example);
}