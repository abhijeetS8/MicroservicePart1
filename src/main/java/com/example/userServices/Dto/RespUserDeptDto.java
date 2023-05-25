package com.example.userServices.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RespUserDeptDto {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;
}