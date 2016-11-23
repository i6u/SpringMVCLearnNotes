package zyr.learn.springmvc.dao;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import zyr.learn.springmvc.model.User;

/**
 * Created by zhouweitao on 2016/11/22.
 *
 */
@Repository("userDao")
public class UserDao extends BaseDao<User> implements IUserDao {
    @Override
    public User login(String username, String password) {
        Query<User> query = getSession().createQuery("form User u where u.username=:un and u.password=:pw")
                .setParameter("un",username).setParameter("pw",password);
        return query.uniqueResult();
    }
}
