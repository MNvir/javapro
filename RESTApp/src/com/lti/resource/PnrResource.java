package com.lti.resource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.lti.resource.Passenger.Gender;
import com.lti.resource.Passenger.Status;

@Path("/pnr")
public class PnrResource {

	@GET
	//@Produces("application/json") -- spelling mistake possible
	@Produces(MediaType.APPLICATION_JSON)
	public Pnr check(@QueryParam("pnrNo") int pnrNo, @Context HttpServletResponse response) {
		//enabling CORS
		//response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		Pnr pnr = new Pnr();
		pnr.setPnrNo(pnrNo);
		pnr.setTrainNo(12345);
		pnr.setTravelDate(LocalDate.of(2020, 6, 18));
		
		List<Passenger> passengers = new ArrayList<Passenger>();
		passengers.add(new Passenger("Mani", Gender.MALE, Status.RAC));
		passengers.add(new Passenger("Joey", Gender.MALE, Status.RAC));
		passengers.add(new Passenger("Gavin", Gender.FEMALE, Status.CONFIRMED));
		pnr.setPassengers(passengers);
		
		return pnr;
	}
}
