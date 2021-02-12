package pe.com.intercorp.dto;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


import com.fasterxml.jackson.annotation.JsonFormat;

import pe.com.intercorp.util.Constants;


public class ClientDto {
	
	@Min(value=Constants.CLIENT_MIN_VALID_AGE,message=Constants.CLIENT_AGE_NOT_ALLOWED_VALIDATOR_MESSAGE)
	@Max(value=Constants.CLIENT_MAX_VALID_AGE,message=Constants.CLIENT_AGE_NOT_ALLOWED_VALIDATOR_MESSAGE)
	private Integer age;
    @NotBlank(message = Constants.CLIENT_BLANK_FIRSTNAME_VALIDATOR_MESSAGE)
	private String firstName;
    @NotBlank(message =Constants.CLIENT_BLANK_LASTNAME_VALIDATOR_MESSAGE)
	private String lastName;
    
	private Date dateOfBirth;
	
	public ClientDto() {
		super();
	}
	
	public ClientDto(Integer age, String firstName, String lastName, Date dateOfBirth) {
		super();
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}

	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="EST")
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
}
