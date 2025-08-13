package edu.bw.dao;

import edu.bw.dto.SelectUserByConditionForm;
import edu.bw.po.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface UserDao {
    /**
     *
     * @param user
     * @return
     */
    Integer userLogin(User user);

    /**
     *
     * @param selectCondition 用户相关的查询参数
     * @return 查询出用户以及关联的角色和部门信息
     */
    List<Map<String, Object>> selectUserByCondition(SelectUserByConditionForm selectCondition);

    /**
     *
     * @param selectCondition 用户相关的查询参数
     * @return 根据条件查询的总条数
     */
    Long selectUserByConditionCount(SelectUserByConditionForm selectCondition);

    /**
     *
     * @param user
     * @return
     */
    Integer insert(User user);

    /**
     *
     * @param userId
     * @return
     */
    List<Map<String, Object>> selectById(Integer userId);

    /**
     *
     * @param user
     * @return
     */
    Integer update(User user);

    /**
     *
     * @param ids
     * @return
     */
    Integer deleteUserByIds(List<Integer> ids);
}
