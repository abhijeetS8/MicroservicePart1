package com.example.userServices.ServiceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.userServices.Dto.DepartmentDto;
import com.example.userServices.Dto.ResponseDto;
import com.example.userServices.Dto.RespUserDeptDto;
import com.example.userServices.Dto.UserDto;
import com.example.userServices.Entity.User;
import com.example.userServices.Repository.UserRepository;
import com.example.userServices.Service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public ResponseDto getUser(Long userId) {

		ResponseDto responseDto = new ResponseDto();
		User user = userRepository.findById(userId).get();
		UserDto userDto = mapToUser(user); // This method is for mapping the authentication token with the user name.

		// To call department service. //configure RestTemplate class in spring starter
		// project .
		ResponseEntity<DepartmentDto> responseEntity = restTemplate
				.getForEntity("http://localhost:8080/api/departments/" + user.getDepartmentId(), DepartmentDto.class);

		DepartmentDto departmentDto = responseEntity.getBody();

		System.out.println(responseEntity.getStatusCode());

		responseDto.setUser(userDto);
		responseDto.setDepartment(departmentDto);

		return responseDto;
	}

	private UserDto mapToUser(User user) {

		UserDto userDto = new UserDto();

		userDto.setId(user.getId());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setEmail(user.getEmail());

		return userDto;
	}

	@Override
	public RespUserDeptDto getusers(Long userId) {
		
		RespUserDeptDto respUserDeptDto = new RespUserDeptDto();
		User user = userRepository.findById(userId).get();
		UserDto userDto = mapToUser(user); // This method is for mapping the authentication token with the user name.

		// To call department service. //configure RestTemplate class in spring starter
		// project .
		ResponseEntity<DepartmentDto> responseEntity = restTemplate
				.getForEntity("http://localhost:8080/api/departments/" + user.getDepartmentId(), DepartmentDto.class);

		DepartmentDto departmentDto = responseEntity.getBody();

		System.out.println(responseEntity.getStatusCode());
		
		respUserDeptDto = mapToUserDept(userDto,departmentDto);

		return respUserDeptDto;
	}

      private RespUserDeptDto mapToUserDept(UserDto userDto,DepartmentDto departmentDto){
    	
        RespUserDeptDto respUserDeptDto = new RespUserDeptDto();
        
        respUserDeptDto.setId(userDto.getId());
        respUserDeptDto.setFirstName(userDto.getFirstName());
        respUserDeptDto.setLastName(userDto.getLastName());
        respUserDeptDto.setEmail(userDto.getEmail());
        respUserDeptDto.setDepartmentCode(departmentDto.getDepartmentCode());
        respUserDeptDto.setDepartmentAddress(departmentDto.getDepartmentAddress());
        respUserDeptDto.setDepartmentName(departmentDto.getDepartmentName());
        
        return respUserDeptDto;
    }

}
