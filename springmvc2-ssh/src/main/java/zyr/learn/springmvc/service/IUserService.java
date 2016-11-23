package zyr.learn.springmvc.service;


import zyr.learn.springmvc.model.User;
import zyr.learn.springmvc.util.Pager;

/**
 * Created by zhouweitao on 2016/11/14.
 *
 */
public interface IUserService {
    void create(User user);
    void update(User user);
    void delete(String id);
    User queryById(String id);
    Pager<User> queryUser();

    User login(String username,String password);
}
