package edu.bw.dao;

import edu.bw.dto.SelectDeptByConditionForm;
import edu.bw.dto.UpdateDeptForm;
import edu.bw.po.Dept;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(locations = "classpath:/spring/application-dao.xml")
class DeptDaoTest {

    @Autowired
    private DeptDao deptDao;

    @Test
    void selectDeptByCondition() {
        deptDao.selectDeptByCondition(new SelectDeptByConditionForm("",1,10,0)).forEach(
                System.out::println
        );
    }

    @Test
    void selectDeptByConditionCount() {
    }

    @Test
    void insert() {
        deptDao.insert(new Dept(null,"测试","12872298765","87656653@qq.com","测试"));
    }

    @Test
    void selectById() {
        deptDao.selectById(3).forEach(System.out::println);
    }

    @Test
    void update() {
        deptDao.update(new UpdateDeptForm(7,"测试部门","10984736278","0987625@qq.com","技术部门"));
    }

    @Test
    void selectAllDept() {
        deptDao.selectAllDept().forEach(System.out::println);
    }
}