package edu.bw.dao;

import edu.bw.dto.SelectDeptByConditionForm;
import edu.bw.dto.UpdateDeptForm;
import edu.bw.po.Dept;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface DeptDao {
    /**
     *
     * @param selectCondition 查询相关的参数
     * @return 查询的数据,每行数据封装一个Map<String, Object> (key代表列名,value代表该列的值),再把所有map存储到List,返回List
     */
    List<Map<String, Object>> selectDeptByCondition(SelectDeptByConditionForm selectCondition);

    /**
     *
     * @param selectCondition 查询相关的参数
     * @return 查询到的总条数
     */
    Long selectDeptByConditionCount(SelectDeptByConditionForm selectCondition);

    /**
     *
     * @param dept
     * @return
     */
    Integer insert(Dept dept);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    List<Map<String, Object>> selectById(Integer id);

    /**
     * 更新
     * @param updateDeptForm
     * @return
     */
    Integer update(UpdateDeptForm updateDeptForm);

    /**
     *
     * @param ids 要删除的部门id
     * @return 部门下没有员工,返回true,否则返回false
     */
    boolean selectCanDelete(List<Integer> ids);

    /**
     *
     * @param ids 根据ids中包含的部门id删除相关部门
     * @return 删除的部门的数量
     */
    Integer deleteDeptByIds(List<Integer> ids);

    /**
     *
     * @return
     */
    List<Map<String, Object>> selectAllDept();

}
