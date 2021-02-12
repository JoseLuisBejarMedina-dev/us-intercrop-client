package pe.com.intercorp.exception;

import java.util.HashMap;
import java.util.Map;

//import java.util.HashMap;
//import java.util.Map;

//import org.hibernate.exception.ConstraintViolationException;
/*import java.io.PrintWriter;
import java.io.StringWriter;
import org.springframework.web.context.request.WebRequest;
*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.validation.FieldError;
import pe.com.intercorp.dto.ResponseMessageDto;

@RestControllerAdvice
public class RestExceptionHandler {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());
	@Value("${error.code}")
	private String errorCode;
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
	  final MethodArgumentNotValidException ex,WebRequest request) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        
	        errors.put(fieldName, errorMessage);
	    });
	    LOGGER.error("Exception: ",ex.getMessage());
	    return errors;
	}

	@ExceptionHandler(Exception.class)
    public  ResponseEntity<Object> handleAllExceptions(final Exception ex,WebRequest request) {
		ResponseMessageDto<String> responseMessageDto=new ResponseMessageDto<>();
		String errorMessage=ex.getMessage();
		responseMessageDto.setCode(errorCode);
		responseMessageDto.setError(errorMessage);
		responseMessageDto.setObject(null);
		LOGGER.error("Exception: ",errorMessage);
    	return new ResponseEntity<>((Object)responseMessageDto,HttpStatus.INTERNAL_SERVER_ERROR);
    }


	/*
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ResponseEntity<String> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
		return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	*/
	/*
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
		return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = error.getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}
	
	
	
	
	*
	*/
	

/*	
   
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ResponseMessageDto<String>> handleAllExceptions(Exception ex, WebRequest request) {
		ResponseMessageDto<String> responseMessageDto=new ResponseMessageDto<>();
		responseMessageDto.setCode();
		responseMessageDto.setError(error);
		responseMessageDto.setObject(object);
		StringWriter stringWriter = new StringWriter();
		ex.printStackTrace(new PrintWriter(stringWriter));
		LOGGER.error(stringWriter.toString());
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
*/
}
