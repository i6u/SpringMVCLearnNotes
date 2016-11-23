package zyr.learn.springmvc.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import zyr.learn.springmvc.util.Pager;
import zyr.learn.springmvc.util.SystemContext;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Objects;

/**
 * Created by zhouweitao on 2016/11/14.
 *
 */
public class BaseDao<T> implements IBaseDao<T> {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name="sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    private Class<T> getClazz() {
        return (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void add(T t) {
        this.getSession().save(t);
    }

    @Override
    public void del(int id) {
        this.getSession().delete(this.findOne(id));
    }

    @Override
    public void update(T t) {
        this.getSession().merge(t);
    }

    @Override
    public T findOne(int id) {
        return this.getSession().load(this.getClazz(),id);
    }

    @Override
    public List<T> list(String hql, Objects... obj) {
        Query query = this.getSession().createQuery(hql);
        for (int i = 0; i < obj.length; i++) {
            query.setParameter(i, obj[i]);
        }
        return query.list();
    }

    @Override
    public Pager<T> findAll(String hql, Object... obj) {
        Pager<T> pages = new Pager<T>();
        int pageOffset = SystemContext.getPageOffset();
        int pageSize = SystemContext.getPageSize();
        Query q = this.getSession().createQuery(hql);
        Query cq = this.getSession().createQuery(getCountHql(hql));

        for (int i = 0; i < obj.length; i++) {
            q.setParameter(i, obj[i]);
            cq.setParameter(i, obj[i]);
        }
        long totalRecord = (Long)cq.uniqueResult();
        q.setFirstResult(pageOffset);
        q.setMaxResults(pageSize);
        List<T> datas = q.list();
        pages.setDatas(datas);
        pages.setPagerOffset(pageOffset);
        pages.setPagerSize(pageSize);
        pages.setTotalRecord(totalRecord);
        return pages;
    }

    private String getCountHql(String hql) {
        String f = hql.substring(0, hql.indexOf("from"));
        if(f.equals("")) {
            hql = "select count(*) "+hql;
        } else {
            hql = hql.replace(f, "select count(*) ");
        }
        hql = hql.replace("fetch"," ");
        return hql;
    }
}
