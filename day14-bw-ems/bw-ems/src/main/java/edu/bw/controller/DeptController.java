package edu.bw.controller;


import edu.bw.common.CommonResult;
import edu.bw.dto.SelectDeptByConditionForm;
import edu.bw.dto.UpdateDeptForm;
import edu.bw.po.Dept;
import edu.bw.service.DeptService;
import edu.bw.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dept")
@CrossOrigin
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 按照条件查询部门信息
     * @param selectDeptByConditionForm
     * @return
     */
    @PostMapping("/selectDeptByCondition")
    public CommonResult selectDeptByCondition(@RequestBody SelectDeptByConditionForm selectDeptByConditionForm) {
        PageUtils pageUtils = deptService.selectDeptByCondition(selectDeptByConditionForm);
        return CommonResult.ok().put("page", pageUtils);
    }

    /**
     * 根据id查询部门
     *
     */
    @PostMapping("/selectById")
    public CommonResult selectById(@RequestBody Dept dept) {
        return CommonResult.ok(deptService.selectById(dept.getId()).get(0));
    }

    /**
     * 插入
     */
    @PostMapping("/insert")
    public CommonResult insert(@RequestBody Dept dept) {
        Integer rows = deptService.insert(dept);
        return CommonResult.ok().put("rows", rows);
    }

    /**
     * 更新
     * @param updateDeptForm
     * @return
     */
    @PostMapping("/update")
    public CommonResult update(@RequestBody UpdateDeptForm updateDeptForm) {
        Integer rows = deptService.update(updateDeptForm);
        return CommonResult.ok().put("rows", rows);
    }

    /**
     * 删除
     */
//{"ids":[1,8]}
    @PostMapping("/deleteDeptByIds")
    public CommonResult deleteDeptByIds(@RequestBody Map<String,List<Integer>> params) {
        Integer i = deptService.deleteDeptByIds(params.get("ids"));
        return CommonResult.ok().put("rows", i);
    }

    /**
     * 查所有
     */
    @GetMapping("/selectAllDept")
    public CommonResult selectAllDept() {
        List<Map<String, Object>> maps = deptService.selectAllDept();
//        maps.forEach(System.out::println);
        return CommonResult.ok().put("list", maps);
    }
}
