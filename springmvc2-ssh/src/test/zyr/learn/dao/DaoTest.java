package zyr.learn.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import zyr.learn.springmvc.dao.IUserDao;
import zyr.learn.springmvc.model.User;
import zyr.learn.springmvc.service.IUserService;

import javax.annotation.Resource;

/**
 * Created by zhouweitao on 2016/11/22.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "/beans.xml")
public class DaoTest {
    @Resource(name = "userDao")
    private IUserDao userDao;

    @Resource(name = "userService")
    private IUserService userService;

    @Test
    public void add() throws Exception {
        User user = new User();
        user.setUsername("jock");
        user.setPassword("jock1234");
        user.setEmail("abc@123.com");
        user.setPic("/a/b/c.jpg");

        userService.create(user);
    }
}
