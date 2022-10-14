package com.example.dto;

import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInput {
	
	private Integer id;
	private String name;
	private String surname;
	@Positive
	private Integer age;

}