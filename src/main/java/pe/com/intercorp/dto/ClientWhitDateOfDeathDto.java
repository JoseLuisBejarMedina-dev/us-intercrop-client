package pe.com.intercorp.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ClientWhitDateOfDeathDto {
	private Integer age;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private Date probalbeDateOfDeath;
	
	public ClientWhitDateOfDeathDto(Integer age, String firstName, String lastName, Date dateOfBirth,
			Date probalbeDateOfDeath) {
		super();
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.probalbeDateOfDeath = probalbeDateOfDeath;
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
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	public Date getDateOfDeath() {
		return probalbeDateOfDeath;
	}
	
	public void setDateOfDeath(Date dateOfDeath) {
		this.probalbeDateOfDeath = dateOfDeath;
	}
	
}
