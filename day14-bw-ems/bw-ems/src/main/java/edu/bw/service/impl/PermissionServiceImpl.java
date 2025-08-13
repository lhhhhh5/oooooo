package edu.bw.service.impl;

import edu.bw.dao.PermissionDao;
import edu.bw.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Map<String, Object>> selectAllPermission() {
        return permissionDao.selectAllPermission();
    }

}
