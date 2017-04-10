package com.revature.json.parser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Car;
import com.revature.beans.Passenger;

public class JSONConverter {
	
	public Passenger getPassenger( String json ) throws JsonParseException, JsonMappingException, IOException{
		return new ObjectMapper().readValue( json, Passenger.class );
	}
	
	public Car getCar( String json ) throws JsonParseException, JsonMappingException, IOException{
		return new ObjectMapper().readValue( json, Car.class );
	}
	
	public String getJSON( Car car) throws JsonProcessingException{
		return new ObjectMapper().writeValueAsString( car );		
	}
}
