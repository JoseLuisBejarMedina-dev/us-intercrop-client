package pe.com.intercorp.facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import pe.com.intercorp.dto.ClientDto;
import pe.com.intercorp.dto.ClientKPIDto;
import pe.com.intercorp.dto.ClientWhitDateOfDeathDto;
import pe.com.intercorp.dto.ResponseMessageDto;
import pe.com.intercorp.model.Client;
import pe.com.intercorp.service.ClientService;
@Service
public class ClientFacade {
	@Value("${success.code}")
	private String successCode;
	@Value("${error.code}")
	private String errorCode;
	@Value("${client.message.create.success}")
	private String successCreateOfClientMessage;
	
	@Autowired
	private ClientService clientService;
	
	public ResponseMessageDto<String> createCliente(ClientDto clientDto){
		ResponseMessageDto<String> responseMessage=new ResponseMessageDto<String>();

		Integer age=clientDto.getAge();
		String firstName=clientDto.getFirstName();
		String lastName=clientDto.getLastName();
		Date dateOfBirth=clientDto.getDateOfBirth();
		clientService.createClient(new Client(age, firstName, lastName, dateOfBirth));
		
		responseMessage.setCode(successCode);
		responseMessage.setError(null);
		responseMessage.setObject(successCreateOfClientMessage);
		
		return responseMessage;
	}
	public ResponseMessageDto<ClientKPIDto> getClientsKPI(){
		ResponseMessageDto<ClientKPIDto> responseMessage=new ResponseMessageDto<ClientKPIDto>();
		ClientKPIDto clientKPIdto;
		Double averageAge=clientService.getAverageAgeOfAllClients();			
		Double starndarDeviationOfAge=clientService.getStandartDeviationOfAllClients();
			
		clientKPIdto=new ClientKPIDto(averageAge, starndarDeviationOfAge);
		
		responseMessage.setObject(clientKPIdto);		
		responseMessage.setCode(successCode);
		responseMessage.setError(null);
	
		return responseMessage;
	}
	public ResponseMessageDto<List<ClientWhitDateOfDeathDto>> getListOfClientsWhitProbaleDateOfDeath(){
		ResponseMessageDto<List<ClientWhitDateOfDeathDto>> responseMessage=new ResponseMessageDto<>();
		List<ClientWhitDateOfDeathDto> listOfClientsWhitDateOfDeathDto=new ArrayList<ClientWhitDateOfDeathDto>();

		listOfClientsWhitDateOfDeathDto=clientService.getAllClientsWhitProbaleDateOfDeath();
		
		responseMessage.setObject(listOfClientsWhitDateOfDeathDto);	
		responseMessage.setCode(successCode);
		responseMessage.setError(null);
			
	
		return responseMessage;
	}
}
