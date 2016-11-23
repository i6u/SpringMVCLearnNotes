package zyr.learn.springmvc.dao;

import zyr.learn.springmvc.model.User;

/**
 * Created by zhouweitao on 2016/11/22.
 */
public interface IUserDao extends IBaseDao<User>{
    User login(String username,String password);
}
