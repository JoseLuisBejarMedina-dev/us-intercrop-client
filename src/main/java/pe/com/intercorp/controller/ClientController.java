package pe.com.intercorp.controller;

import java.util.List;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import pe.com.intercorp.dto.ClientDto;
import pe.com.intercorp.dto.ClientKPIDto;
import pe.com.intercorp.dto.ClientWhitDateOfDeathDto;
import pe.com.intercorp.dto.ResponseMessageDto;
import pe.com.intercorp.facade.ClientFacade;
import pe.com.intercorp.util.ConvertToUtils;

@RestController
@RequestMapping(value="/intercorp")
public class ClientController{
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	ClientFacade clientFacade;
	

	@PostMapping("/creacliente")
	public ResponseEntity<ResponseMessageDto<String>> createCliente(@Valid @RequestBody ClientDto clientDto){
	
		LOGGER.info("START [POST]/create-prescription-: {}",ConvertToUtils.convertFromObjectToJson(clientDto));
		ResponseMessageDto<String> responseMessage=clientFacade.createCliente(clientDto);
		LOGGER.info("END [POST] /create-prescription: {}",ConvertToUtils.convertFromObjectToJson(responseMessage));
		
		return new ResponseEntity<ResponseMessageDto<String>>(responseMessage,HttpStatus.OK);
	}
	@GetMapping("/kpideclientes")
	public ResponseEntity<ResponseMessageDto<ClientKPIDto>>  getClientsKPI(){
		LOGGER.info("START [GET]/get-clients-kpi: {}");
		ResponseMessageDto<ClientKPIDto> responseMessage=clientFacade.getClientsKPI();
		LOGGER.info("END [GET] /get-clients-kpi: {}",ConvertToUtils.convertFromObjectToJson(responseMessage));
		
		return new ResponseEntity<ResponseMessageDto<ClientKPIDto>>(responseMessage,HttpStatus.OK);
		 
	}
	@GetMapping("/listclientes")
	public ResponseEntity<ResponseMessageDto<List<ClientWhitDateOfDeathDto>>> getListOfClientsWhitProbaleDateOfDeath(){
		LOGGER.info("START [GET]/get-all-clients: {}");	
		ResponseMessageDto<List<ClientWhitDateOfDeathDto>> responseMessage=clientFacade.getListOfClientsWhitProbaleDateOfDeath();
		LOGGER.info("START [GET]/get-all-clients: {}",pe.com.intercorp.util.ConvertToUtils.convertFromObjectToJson(responseMessage));	
		
		return new  ResponseEntity<ResponseMessageDto<List<ClientWhitDateOfDeathDto>>>(responseMessage,HttpStatus.OK);
		
	}
}
