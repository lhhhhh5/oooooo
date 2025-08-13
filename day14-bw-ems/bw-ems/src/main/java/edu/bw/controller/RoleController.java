package edu.bw.controller;


import edu.bw.common.CommonResult;
import edu.bw.dto.InsertRoleForm;
import edu.bw.dto.SelectRoleByConditionForm;
import edu.bw.dto.UpdateRoleForm;
import edu.bw.po.Role;
import edu.bw.service.RoleService;
import edu.bw.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role")
@CrossOrigin
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/selectRoleByCondition")
    public CommonResult selectRoleByCondition(@RequestBody SelectRoleByConditionForm selectRoleByConditionForm) {
        PageUtils pageUtils = roleService.selectRoleByCondition(selectRoleByConditionForm);
        return CommonResult.ok().put("page", pageUtils);
    }

    @PostMapping("/insert")
    public CommonResult insert(@RequestBody InsertRoleForm insertRoleForm) {
        Integer insert = roleService.insert(insertRoleForm);
        return CommonResult.ok().put("rows", insert);
    }

    /**
     * 根据id查询角色，角色关联的权限
     * @param role
     * @return
     */
    @PostMapping("/selectById")
    public CommonResult selectById(@RequestBody Role role) {
        List<Map<String, Object>> maps = roleService.selectById(role.getId());
        return CommonResult.ok(maps.get(0));
    }

    /**
     * 更新的信息
     * @param updateRoleForm
     * @return
     */
    @PostMapping("/update")
    public CommonResult update(@RequestBody UpdateRoleForm updateRoleForm) {
        Integer update = roleService.update(updateRoleForm);
        return CommonResult.ok().put("rows", update);
    }

    /**
     * 删除
     */
    @PostMapping("/deleteRoleByIds")
    public CommonResult deleteRoleByIds(@RequestBody Map<String,List<Integer>> ids) {
        List<Integer> ids1 = ids.get("ids");
        roleService.deleteRoleByIds(ids1);
        return CommonResult.ok().put("rows", ids1);
    }

    /**
     * 查所有
     */
    @GetMapping("/selectAllRole")
    public CommonResult selectAllRole() {
        List<Map<String, Object>> maps = roleService.selectAllRole();
        return CommonResult.ok().put("list", maps);
    }
}
