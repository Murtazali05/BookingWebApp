package ru.murtazali.book.DAO;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class AbstractDAOImpl<T, PK extends Serializable> implements AbstractDAO<T, PK> {

    private Class<T> type;
    private SessionFactory sessionFactory;

    public AbstractDAOImpl(Class<T> type) {
        this.type = type;
    }

    @Autowired
    private void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        try { return sessionFactory.getCurrentSession(); }
        catch (HibernateException e) { return sessionFactory.openSession(); }
    }

    protected Criteria createCriteria() {
        return getSession().createCriteria(type);
    }


    public PK save(T newInstance) {
        Session session = getSession();
        session.beginTransaction();
        PK id = (PK) session.save(newInstance);
        session.getTransaction().commit();
        session.close();
        return id;
    }

    public T get(PK id) {
        Session session = getSession();
        T object = session.get(type, id);
        session.close();
        return object;
    }

    public void update(T transientObject) {
        Session session = getSession();
        session.beginTransaction();
        session.update(transientObject);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(T persistentObject) {
        Session session = getSession();
        session.beginTransaction();
        session.delete(persistentObject);
        session.getTransaction().commit();
        session.close();
    }

    public List<T> list() {
        return (List<T>) createCriteria().list();
    }
}

