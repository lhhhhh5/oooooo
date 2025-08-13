package edu.bw.service;

import edu.bw.dto.InsertUserForm;
import edu.bw.dto.SelectUserByConditionForm;
import edu.bw.dto.UpdateUserForm;
import edu.bw.po.User;
import edu.bw.utils.PageUtils;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     *
     * @param user 封装了user相关数据的User对象
     * @return 查询到的用户id,如果有返回id值,如果没有返回null
     */
    Integer userLogin(User user);

    /**
     *
     * @param selectCondition 用户相关的查询参数
     * @return 将分页相关的参数以及查询数据封装到PageUtils中返回
     */
    PageUtils selectUserByCondition(SelectUserByConditionForm selectCondition);

    /**
     *
     * @param insertUserForm 插入的用户的信息
     * @return 插入的条数
     */
    Integer insert(InsertUserForm insertUserForm);

    /**
     *
     * @param userId 用户的id
     * @return 根据用户id查询的该用户的信息
     */
    List<Map<String, Object>> selectById(Integer userId);

    /**
     *
     * @param updateUserForm 修改的用户信息
     * @return 更新的条数
     */
    Integer update(UpdateUserForm updateUserForm);

    /**
     *
     * @param ids 用户的id集合
     * @return 删除的条数
     */
    Integer deleteUserByIds(List<Integer> ids);
}
