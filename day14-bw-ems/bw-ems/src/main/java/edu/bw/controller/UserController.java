package edu.bw.controller;


import edu.bw.common.CommonResult;
import edu.bw.dto.InsertUserForm;
import edu.bw.dto.SelectUserByConditionForm;
import edu.bw.dto.UpdateUserForm;
import edu.bw.po.User;
import edu.bw.service.UserService;
import edu.bw.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public CommonResult login(@RequestBody User user) {
        Integer userId = userService.userLogin(user);

//        return CommonResult.ok().put("userId", (userId!=null?"登录成功":"登录失败"));
        return CommonResult.ok().put("result", (userId!=null?"登录成功":"登录失败"));
    }


    @PostMapping("/selectUserByCondition")
    public CommonResult selectUserByCondition(@RequestBody SelectUserByConditionForm selectUserByConditionForm) {
        PageUtils pageUtils = userService.selectUserByCondition(selectUserByConditionForm);
        return CommonResult.ok().put("page", pageUtils);
    }


    @PostMapping("/insert")
    public CommonResult insert(@RequestBody InsertUserForm insertUserForm) {
        Integer userId = userService.insert(insertUserForm);
        return CommonResult.ok().put("rows",userId);
    }

    @PostMapping("/selectById")
    public CommonResult selectById(@RequestBody Map<String,Integer> param) {
        List<Map<String, Object>> maps = userService.selectById(param.get("userId"));
        return CommonResult.ok(maps.get(0));
    }

    @PostMapping("/update")
    public CommonResult update(@RequestBody UpdateUserForm updateUserForm) {
        Integer update = userService.update(updateUserForm);
        return CommonResult.ok().put("rows",update);
    }

    @PostMapping("/deleteUserByIds")
    public CommonResult deleteUserByIds(@RequestBody Map<String,List<Integer>> param) {
        Integer userIds = userService.deleteUserByIds(param.get("ids"));
        return CommonResult.ok().put("rows",userIds);
    }
}
