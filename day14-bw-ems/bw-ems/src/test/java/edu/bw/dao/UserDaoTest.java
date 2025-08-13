package edu.bw.dao;

import edu.bw.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


@SpringJUnitConfig(locations = "classpath:spring/application-dao.xml")
class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    void userLogin() {
        System.out.println(userDao.userLogin(
                new User("zhangsan","zhangsan")));
        System.out.println(userDao.userLogin(
                new User("zhangsan","12345")));
    }


}