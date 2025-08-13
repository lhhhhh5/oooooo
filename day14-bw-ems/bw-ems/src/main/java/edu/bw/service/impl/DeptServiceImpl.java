package edu.bw.service.impl;

import cn.hutool.core.util.ObjectUtil;
import edu.bw.dao.DeptDao;
import edu.bw.dto.SelectDeptByConditionForm;
import edu.bw.dto.UpdateDeptForm;
import edu.bw.po.Dept;
import edu.bw.service.DeptService;
import edu.bw.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Map;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public PageUtils selectDeptByCondition(SelectDeptByConditionForm selectCondition) {

        //先计算出起始索引
        selectCondition.setStart((selectCondition.getPage() - 1) * selectCondition.getLength());

        //设置部门模糊查询
        if(!ObjectUtils.isEmpty(selectCondition.getDeptName())){
            selectCondition.setDeptName("%"+selectCondition.getDeptName()+"%");
        }

        //1.根据条件查询的数据
        List<Map<String, Object>> list = deptDao.selectDeptByCondition(selectCondition);

        //2.根据条件查询出总条数
        Long count = deptDao.selectDeptByConditionCount(selectCondition);

        int beginIndex = (selectCondition.getPage() - 1) * selectCondition.getLength();

        /**
         * list: 当前页的数据
         * count: 总条数
         * beginIndex: 起始索引
         * selectCondition.getLength(): 每页显示条数
         */
        return new PageUtils(list, count, beginIndex, selectCondition.getLength());
    }

    @Override
    @Transactional
    public Integer insert(Dept dept) {
        return deptDao.insert(dept);
    }

    @Override
    public List<Map<String, Object>> selectById(Integer id) {
        return deptDao.selectById(id);
    }

    @Override
    public Integer update(UpdateDeptForm updateDeptForm) {
        return deptDao.update(updateDeptForm);
    }

    @Override
    @Transactional
    public Integer deleteDeptByIds(List<Integer> ids) {
        Integer rows = 0;
        //判断被删除的部门下是否有员工,如果没有员工才允许删除
        if(deptDao.selectCanDelete(ids)){
            rows = deptDao.deleteDeptByIds(ids);
        }
        return rows;
    }

    @Override
    public List<Map<String, Object>> selectAllDept() {
        return deptDao.selectAllDept();
    }


}
