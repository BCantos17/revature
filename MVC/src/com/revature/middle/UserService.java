package com.revature.middle;

import javax.naming.AuthenticationException;

import com.revature.bean.User;
import com.revature.data.DataFacade;

public class UserService {
	
	public User authenticate(String username, String password){
		/*DataFacade dataTier = new DataFacade();
		User user = dataTier.getUserByName(username);
		if(user == null) throw new AuthenticationException();
		if(user.getPassword().equal(password)){
			return user;
		}else {
			throw new AuthenticationException()
		}*/
		return null;
	}
}
