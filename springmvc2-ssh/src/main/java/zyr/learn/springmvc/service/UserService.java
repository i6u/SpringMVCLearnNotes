package zyr.learn.springmvc.service;

import org.springframework.stereotype.Service;
import zyr.learn.springmvc.dao.IUserDao;
import zyr.learn.springmvc.model.User;
import zyr.learn.springmvc.util.Pager;

import javax.annotation.Resource;

/**
 * Created by zhouweitao on 2016/11/14.
 *
 */
@Service("userService")
public class UserService implements IUserService {
    private IUserDao userDao;

    public IUserDao getUserDao() {
        return userDao;
    }

    @Resource(name = "userDao")
    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void create(User user) {
        userDao.add(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(String id) {
        userDao.del(Integer.parseInt(id));
    }

    @Override
    public User queryById(String id) {
        return userDao.findOne(Integer.parseInt(id));
    }

    @Override
    public Pager<User> queryUser() {
        return userDao.findAll("from User");
    }

    @Override
    public User login(String username, String password) {
        return userDao.login(username,password);
    }
}
