package com.lm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lm.mapping.MesMapper;
import com.lm.mapping.UserMapper;
import com.lm.model.User;
import com.lm.service.UserService32;

@Service("usi32")
public class UserServiceImpl implements UserService32 {
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private MesMapper mesMapper;		
	
	@Override
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public void testTX(String mesId) {
		
		int ct = this.mesMapper.countMesList(mesId);
		if(ct == 0){
			
			User user = new User();
			user.setUserId(mesId);
			
			this.userMapper.insertUser(user);			
			this.mesMapper.insertMes(mesId);
			
			//int i = 1/0;
			
		}
		
	}

}
