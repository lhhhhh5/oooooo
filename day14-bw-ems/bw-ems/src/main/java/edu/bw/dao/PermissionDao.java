package edu.bw.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PermissionDao {
    /**
     *
     * @return
     */
    List<Map<String, Object>> selectAllPermission();

}
