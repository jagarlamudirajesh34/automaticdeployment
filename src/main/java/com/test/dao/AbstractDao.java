package com.test.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

 
public abstract class AbstractDao implements Dao {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
 
    public void save(Object entity) {
    	if(entity != null)
    		getSession().save(entity);
    }
    public void saveOrUpdate(Object entity) {
    	if(entity != null)
    		getSession().saveOrUpdate(entity);
    }
    
    public void update(Object entity) {
    	if(entity != null)
    		getSession().update(entity);
    }
 
    public void delete(Object entity) {
    	if(entity != null)
    		getSession().delete(entity);
    }
}
