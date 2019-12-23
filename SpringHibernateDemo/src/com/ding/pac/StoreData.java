package com.ding.pac;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData implements StoreDataInterface {
  public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
private Employee  employee;
	@Override
	public void StoreData() {
		 Configuration cfg=new Configuration();  
	        cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  

	        //creating seession factory object  
	        SessionFactory factory=cfg.buildSessionFactory();  

	        //creating session object  
	        Session session=factory.openSession();  

	        //creating transaction object  
	        Transaction t=session.beginTransaction();  


	        session.persist(this.employee);//persisting the object  

	        t.commit();//transaction is committed  
	        session.close();  

	        System.out.println("successfully saved");  

		
	}

	
	
}
