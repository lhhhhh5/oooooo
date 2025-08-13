package edu.bw.service.impl;

import edu.bw.po.User;
import edu.bw.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:spring/application-*.xml")
class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    void userLogin() {
        System.out.println(userService.userLogin(new
                User("zhangsan","zhangsan")));
    }
}