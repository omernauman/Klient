package org.omer.jaxrs.forsikring.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Test;
import org.omer.jaxrs.forsikring.model.Contract;

public class RestAPIClient {
	private static final List<String> INSURANCE_TYPES = new ArrayList<>(
			Arrays.asList("Bilforsikring", "Boligforsikring", "Helseforsikring"
			)
			);
	@Test
	public void testCreate() {
		Client client = ClientBuilder.newClient();		
		WebTarget baseTarget = client.target("http://localhost:8080/forsikring/webapi/");
		WebTarget contractTarget = baseTarget.path("contract");
		
		Contract contractPost = new Contract();
		contractPost.setCustomerName("Omer Nauman");
		contractPost.setPersonalNr("123");
		contractPost.setProductName(INSURANCE_TYPES.get(1));
		
		Response postResponse = contractTarget
				.request()
				.post(Entity.json(contractPost));		
		assertEquals("Should return status 200", 200, postResponse.getStatus());
	}
	
	@Test
	public void testGet() {
		Client client = ClientBuilder.newClient();		
		WebTarget baseTarget = client.target("http://localhost:8080/forsikring/webapi/");
		WebTarget contractTarget = baseTarget.path("contract");
		Response output = contractTarget.request().get();
        assertEquals("should return status 200", 200, output.getStatus());
        assertNotNull("Should return list", output.getEntity());
        
	}

}
