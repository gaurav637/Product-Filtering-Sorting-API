package com.LoqoApp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.LoqoApp.Payload.apiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
		@ExceptionHandler({ProductNotFoundException.class})
		
		public ResponseEntity<apiResponse> resourceNotFoundExceptionhandler(ProductNotFoundException ex){
			String msg = ex.getMessage();
			apiResponse apiResponse  = new apiResponse(msg,"false");
			return new ResponseEntity<apiResponse>(apiResponse,HttpStatus.NOT_FOUND);
		}
		
		@ExceptionHandler({NoResourceFoundException.class})
		public ResponseEntity<String> NoResourcefoundhandler(NoResourceFoundException ex){
			String str = "url not correct. please correct your url and try again ";
			return new  ResponseEntity<String>(str,HttpStatus.BAD_REQUEST);
		}
		
		@ExceptionHandler({HttpMessageNotReadableException.class})
		public ResponseEntity<String> NoResourcefoundhandler(HttpMessageNotReadableException ex){
			String str = "your request is not valid (Bed Request)";
			return new  ResponseEntity<String>(str,HttpStatus.BAD_REQUEST);
		}


}