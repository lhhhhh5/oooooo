package edu.bw.service;

import java.util.List;
import java.util.Map;

public interface PermissionService {
    /**
     *
     * @return 查询系统中的所有权限
     */
    List<Map<String, Object>> selectAllPermission();

}
