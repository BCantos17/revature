package com.revature.data;

import com.revature.bean.Reimbursement;
import com.revature.bean.User;

public class DataFacade {
/*	public User getUserByName(String username){
		UserDAO dao = new UserDAO();
		return dao.getByUsername(username);
	}*/
	
	public void insert(Reimbursement reimb){
		// get connection using JNDI
		// create DAO objects
		ReimbursementDAO dao =  new ReimbursementDAO();
		// call DAO stuff
		dao.insert(reimb);
		// commit transaction
		// close connection
		// all the complexity of data tier stuff
	}
}
