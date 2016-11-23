package zyr.learn.springmvc.dao;

import zyr.learn.springmvc.util.Pager;

import java.util.List;
import java.util.Objects;

/**
 * Created by zhouweitao on 2016/11/14.
 *
 */
public interface IBaseDao<T> {
    void add(T t);

    void del(int id);

    void update(T t);

    T findOne(int id);

    List<T> list(String hql, Objects... obj);

    Pager<T> findAll(String hql, Object... obj);
}
