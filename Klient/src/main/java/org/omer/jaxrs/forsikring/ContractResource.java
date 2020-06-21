package org.omer.jaxrs.forsikring;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.omer.jaxrs.forsikring.model.Contract;
import org.omer.jaxrs.forsikring.service.ContractService;

@Path("/contract")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ContractResource {
	
	ContractService contractService = new ContractService();
	
	@GET
	public List<Contract> getContracts() {
		return contractService.getAllContracts();
	}
	
	@POST	
	public Contract addContract(Contract contract) {
		return contractService.addContract(contract);
	}
	
}
