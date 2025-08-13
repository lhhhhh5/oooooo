package edu.bw.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import edu.bw.dao.UserDao;
import edu.bw.dto.InsertUserForm;
import edu.bw.dto.SelectUserByConditionForm;
import edu.bw.dto.UpdateUserForm;
import edu.bw.po.User;
import edu.bw.service.UserService;
import edu.bw.utils.PageUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.logging.SimpleFormatter;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;//Service中所有的方法都能够使用userDao

    @Override
    public Integer userLogin(User user) {
        return userDao.userLogin(user);
    }

    @Override
    public PageUtils selectUserByCondition(SelectUserByConditionForm selectCondition) {
        //起始索引
        selectCondition.setStart((selectCondition.getPage() - 1) * selectCondition.getLength());

        //模糊查询格式name
        if (!ObjectUtil.isEmpty(selectCondition.getName())) {
            selectCondition.setName("%"+selectCondition.getName()+"%");
        }

        //1.通过dao查询数据
        List<Map<String, Object>> list = userDao.selectUserByCondition(selectCondition);
        Long count = userDao.selectUserByConditionCount(selectCondition);

        //手动将日期转为字符串 yyyy-MM-dd
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (Map<String, Object> map : list) {
            if(map.get("hiredate")!=null){
                String hiredate = simpleDateFormat.format(map.get("hiredate"));
                map.put("hiredate",hiredate);
            }
        }


//        //2.获取查询起始索引
        Integer beginIndex = (selectCondition.getPage() - 1) * selectCondition.getLength();
        return new PageUtils(list, count, beginIndex, selectCondition.getLength());
    }

    @Transactional
    @Override
    public Integer insert(InsertUserForm insertUserForm) {
        //User user = new User();
        //user.setUsername(insertUserForm.getUsername());
        //user.setPassword(insertUserForm.getPassword());
        //....
        User user = new User();
//spring的
//        BeanUtils.copyProperties(insertUserForm, user);

        BeanUtil.copyProperties(insertUserForm, user);
        return userDao.insert(user);
    }

    @Override
    public List<Map<String, Object>> selectById(Integer userId) {
        return userDao.selectById(userId);
    }

    @Override
    @Transactional
    public Integer update(UpdateUserForm updateUserForm) {
        //将UpdateUserForm=>User
        User user = new User();
        BeanUtil.copyProperties(updateUserForm, user);
        user.setId(updateUserForm.getUserId());
        return userDao.update(user);
    }

    @Transactional
    @Override
    public Integer deleteUserByIds(List<Integer> ids) {
        return userDao.deleteUserByIds(ids);
    }
}
