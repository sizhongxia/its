package com.dm.stu.dao;

import com.dm.stu.domain.PGroupPermission;
import com.dm.stu.domain.PGroupPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PGroupPermissionMapper {
    long countByExample(PGroupPermissionExample example);

    int deleteByExample(PGroupPermissionExample example);

    int deleteByPrimaryKey(@Param("permissionGroupId") String permissionGroupId, @Param("permissionId") String permissionId);

    int insert(PGroupPermission record);

    int insertSelective(PGroupPermission record);

    List<PGroupPermission> selectByExample(PGroupPermissionExample example);

    int updateByExampleSelective(@Param("record") PGroupPermission record, @Param("example") PGroupPermissionExample example);

    int updateByExample(@Param("record") PGroupPermission record, @Param("example") PGroupPermissionExample example);
}