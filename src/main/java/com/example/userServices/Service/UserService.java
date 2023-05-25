package com.example.userServices.Service;

import com.example.userServices.Dto.ResponseDto;
import com.example.userServices.Dto.RespUserDeptDto;
import com.example.userServices.Entity.User;

public interface UserService {

	User saveUser(User user);

    ResponseDto getUser(Long userId);
    
	RespUserDeptDto getusers(Long userId);
 
}
