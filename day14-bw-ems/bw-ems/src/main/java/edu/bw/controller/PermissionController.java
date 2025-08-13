package edu.bw.controller;


import edu.bw.common.CommonResult;
import edu.bw.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Permission;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/permission")
@CrossOrigin
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @GetMapping("/selectAllPermission")
    public CommonResult selectAllPermission() {
        List<Map<String, Object>> maps = permissionService.selectAllPermission();
        return CommonResult.ok().put("list", maps);
    }
}
