package edu.bw.service.impl;

import cn.hutool.core.util.ObjectUtil;
import edu.bw.dao.RoleDao;
import edu.bw.dto.InsertRoleForm;
import edu.bw.dto.SelectRoleByConditionForm;
import edu.bw.dto.UpdateRoleForm;
import edu.bw.po.Role;
import edu.bw.service.RoleService;
import edu.bw.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public PageUtils selectRoleByCondition(SelectRoleByConditionForm selectCondition) {
  //
        selectCondition.setStart((selectCondition.getPage() - 1) * selectCondition.getLength());
//
        if (!ObjectUtil.isEmpty(selectCondition.getRoleName())) {
            selectCondition.setRoleName("%"+selectCondition.getRoleName()+"%");
        }


        List<Map<String, Object>> list = roleDao.selectRoleByCondition(selectCondition);
        Long count = roleDao.selectRoleByConditionCount(selectCondition);

        int beginIndex = (selectCondition.getPage() - 1) * selectCondition.getLength();

        return new PageUtils(list, count, beginIndex, selectCondition.getLength());
    }

    @Override
    @Transactional
    public Integer insert(InsertRoleForm insertRoleForm) {
        Role role = new Role();
        role.setRoleName(insertRoleForm.getRoleName());
        role.setPermissions(Arrays.toString(insertRoleForm.getPermissions()));
        role.setDesc(insertRoleForm.getDesc());

        return roleDao.insert(role);
    }

    @Override
    public List<Map<String, Object>> selectById(Integer id) {
        return roleDao.selectById(id);
    }

    @Override
    @Transactional
    public Integer update(UpdateRoleForm updateRoleForm) {
        return roleDao.update(updateRoleForm);
    }

    @Override
    public Integer deleteRoleByIds(List<Integer> ids) {
        Integer rows = 0;
        if(roleDao.selectCanDelete(ids)){
            rows = roleDao.deleteRoleByIds(ids);
        }
        return rows;
    }

    @Override
    public List<Map<String, Object>> selectAllRole() {
        return roleDao.selectAllRole();
    }
}
