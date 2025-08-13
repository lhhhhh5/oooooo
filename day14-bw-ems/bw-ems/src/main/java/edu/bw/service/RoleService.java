package edu.bw.service;

import edu.bw.dto.InsertRoleForm;
import edu.bw.dto.SelectRoleByConditionForm;
import edu.bw.dto.UpdateRoleForm;
import edu.bw.utils.PageUtils;

import java.util.List;
import java.util.Map;

public interface RoleService {
    /**
     *
     * @param selectCondition 角色相关的查询参数
     * @return PageUtils(封装了分页相关的参数信息以及查询数据)
     */
    PageUtils selectRoleByCondition(SelectRoleByConditionForm selectCondition);

    /**
     *
     * @param insertRoleForm 页面传递的角色及权限相关参数
     * @return 插入结果(插入成功:1 插入失败:0)
     */
    Integer insert(InsertRoleForm insertRoleForm);

    /**
     *
     * @param id 角色id
     * @return 该角色id对应的角色信息
     */
    List<Map<String, Object>> selectById(Integer id);

    /**
     *
     * @param updateRoleForm 角色更新相关的数据
     * @return 更新的条数
     */
    Integer update(UpdateRoleForm updateRoleForm);

    /**
     *
     * @param ids 待删除的角色id
     * @return 删除的结果
     */
    Integer deleteRoleByIds(List<Integer> ids);

    /**
     *
     * @return 所有的角色信息
     */
    List<Map<String, Object>> selectAllRole();

}
