package edu.bw.service;

import edu.bw.dto.SelectDeptByConditionForm;
import edu.bw.dto.UpdateDeptForm;
import edu.bw.po.Dept;
import edu.bw.utils.PageUtils;

import java.util.List;
import java.util.Map;

public interface DeptService {
    /**
     *
     * @param selectCondition 查询相关参数
     * @return 根据条件得到的分页查询结果
     */
    PageUtils selectDeptByCondition(SelectDeptByConditionForm selectCondition);

    /**
     *
     * @param dept 新添加的部门信息
     * @return 插入的条数
     */
    Integer insert(Dept dept);

    /**
     *
     * @param id 部门id
     * @return 根据部门id查询到部门相关数据(以列名=列值形式组装数据)
     */
    List<Map<String, Object>> selectById(Integer id);

    /**
     *
     * @param updateDeptForm 页面修改的部门数据
     * @return 修改的条数
     */
    Integer update(UpdateDeptForm updateDeptForm);

    /**
     *
     * @param ids 要删除的部门id
     * @return 删除的部门个数
     */
    Integer deleteDeptByIds(List<Integer> ids);

    /**
     *
     * @return 所有的部门信息
     */
    List<Map<String, Object>> selectAllDept();
}
