package pe.com.intercorp.service;

import java.util.Date;
import java.util.List;

import pe.com.intercorp.dto.ClientWhitDateOfDeathDto;
import pe.com.intercorp.model.Client;

public interface ClientService {
	Date    dateOfBirthByAge(Integer age);   
	Integer getAgeByDateOfBirth(Date date);
	Client  createClient(Client client);
	Double  getAverageAgeOfAllClients();
	Double  getStandartDeviationOfAllClients();
	Date    getClientProbaleDeathDateByBirthDate(Date birthDate);
	List<ClientWhitDateOfDeathDto> getAllClientsWhitProbaleDateOfDeath();
}
