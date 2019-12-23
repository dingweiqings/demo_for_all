package com.ding.cache.ehcache.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class HibernateDaoSupport {
    @Autowired
    private SessionFactory sessionFactory;


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session getSession(){
	return	sessionFactory.openSession();
	}
	
	public void save(Object obj){
		Session session =getSession();
		Transaction tran=session.beginTransaction();
	      try {
	    	  session.save(obj);
	    	  tran.commit();
           } catch (RuntimeException re) {
        	   tran.rollback();
               throw re;
           }finally{
        	   close(session);
           }   
	    
	}
	
	public void close(Session session){
		session.close();
		
	}

}
