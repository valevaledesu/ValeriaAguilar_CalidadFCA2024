package com.fca.calidad.service;

import com.fca.calidad.DAO.IDAOUser;
import com.fca.calidad.model.User;


public class LoginService {
	IDAOUser dao;

	public LoginService(IDAOUser d) {
		this.dao = d;
	}
	
	public boolean login(String name, String pass) {
		
		User u = dao.findByUserName(name);
        boolean result = false;
        if(u != null){
                if (u.getPassword() == pass) {

                    result = true;
                }
                
            
        }
            return result;
		
	}

    
}