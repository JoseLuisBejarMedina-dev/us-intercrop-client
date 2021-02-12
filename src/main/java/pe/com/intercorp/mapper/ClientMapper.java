package pe.com.intercorp.mapper;

import java.util.Date;

import org.springframework.stereotype.Service;

import pe.com.intercorp.dto.ClientWhitDateOfDeathDto;
import pe.com.intercorp.model.Client;

@Service
public class ClientMapper {
	public ClientWhitDateOfDeathDto toClientWhitDateOfDeathDto(Client client,Date dateOfDeath) {
		Integer age=client.getAge();
		String firstName=client.getFirstName();
		String lastName=client.getLastName();
		Date dateOfBirth=client.getDateOfBirth();
		
		return new ClientWhitDateOfDeathDto(age, firstName, lastName, dateOfBirth, dateOfDeath);
	} 
}
