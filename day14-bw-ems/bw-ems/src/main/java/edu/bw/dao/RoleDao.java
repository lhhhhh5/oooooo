package edu.bw.dao;

import edu.bw.dto.SelectRoleByConditionForm;
import edu.bw.dto.UpdateRoleForm;
import edu.bw.po.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface RoleDao {
    /**
     *
     * @param selectCondition 查询参数
     * @return 查询结果 (按照一行一个HashMap形式进行封装,将所有的HashMap放到一个List中返回)
     */
    List<Map<String, Object>> selectRoleByCondition(SelectRoleByConditionForm selectCondition);

    /**
     *
     * @param selectCondition 查询参数
     * @return 总条数
     */
    Long selectRoleByConditionCount(SelectRoleByConditionForm selectCondition);

    /**
     *
     * @param role 插入数据库的角色信息
     * @return 操作的结果
     */
    Integer insert(Role role);

    /**
     *
     * @param id
     * @return
     */
    List<Map<String, Object>> selectById(Integer id);

    /**
     * 先查询在不在，再更新
     * @param updateRoleForm
     * @return
     */
    Integer update(UpdateRoleForm updateRoleForm);

    /**
     *
     * @param ids 待删除的角色的id
     * @return 如果待删除的角色关联的有用户,返回false,不能删,否则返回true
     */
    boolean selectCanDelete(List<Integer> ids);

    /**
     *
     * @param ids 待删除的角色的id
     * @return 删除的条数
     */
    Integer deleteRoleByIds(List<Integer> ids);

    /**
     *
     * @return
     */
    List<Map<String, Object>> selectAllRole();
}
