package pe.com.intercorp.service.impl;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import pe.com.intercorp.dao.ClientDao;
import pe.com.intercorp.dto.ClientWhitDateOfDeathDto;
import pe.com.intercorp.mapper.ClientMapper;
import pe.com.intercorp.model.Client;
import pe.com.intercorp.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	@Value("${client.average.lifetime.expectancy}")
	private int averageLifetimeExpectancy;
	@Autowired
	private ClientDao clientDao;
	@Autowired
	private ClientMapper clientMapper;
	@Override
	public Client createClient(Client client) {
		// TODO Auto-generated method stub

		return clientDao.save(client);
	}

	@Override
	public Double getAverageAgeOfAllClients() {
		// TODO Auto-generated method stub
		return clientDao.findAverageAgeOfAllClients();
	}
  
	@Override
	public Double getStandartDeviationOfAllClients() {
		// TODO Auto-generated method stub
		return clientDao.findStandartDeviationOfAllClients();
	}

	@Override
	public List<ClientWhitDateOfDeathDto> getAllClientsWhitProbaleDateOfDeath() {
		// TODO Auto-generated method stub
		List<ClientWhitDateOfDeathDto> listOfClientsWhitDatesOfDeath=new ArrayList<>();
		clientDao.findAll().forEach(
				c->{
					
					Date dateOfDeath=getClientProbaleDeathDateByBirthDate(c.getDateOfBirth());
					listOfClientsWhitDatesOfDeath.add(clientMapper.toClientWhitDateOfDeathDto(c, dateOfDeath));
				}
		);
		return listOfClientsWhitDatesOfDeath;
	}

	@Override
	public Date getClientProbaleDeathDateByBirthDate(Date birthDate) {
		// TODO Auto-generated method stub
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(birthDate);	
		calendar.add(Calendar.YEAR,averageLifetimeExpectancy);
		
		Date dateOfDeath=calendar.getTime();
		
		return dateOfDeath;
	}

	@Override
	public Integer getAgeByDateOfBirth(Date date) {
		// TODO Auto-generated method stub
		 TimeZone.setDefault(TimeZone.getTimeZone("EST"));
	      //Converting obtained Date object to LocalDate object
	      Instant instant = date.toInstant();
	      ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
	      LocalDate givenDate = zone.toLocalDate();
	      //Calculating the difference between given date to current date.
	      Period period = Period.between(givenDate, LocalDate.now());
	      return period.getYears();

	}

	@Override
	public Date dateOfBirthByAge(Integer age) {
		// TODO Auto-generated method stub
		return null;
	}


}
