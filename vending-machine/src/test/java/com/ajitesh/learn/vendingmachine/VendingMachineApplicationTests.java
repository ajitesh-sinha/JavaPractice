package com.ajitesh.learn.vendingmachine;

import com.ajitesh.learn.vendingmachine.model.Coin;
import com.ajitesh.learn.vendingmachine.model.ProductCode;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
class VendingMachineApplicationTests {

	@Autowired
	TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	@Test
	void contextLoads() {
	}

	@Test
	public void testWithReturnChange() {
		restTemplate.postForLocation("http://localhost:" + port + "/vendingMachine/selectProduct", ProductCode.B4);
		restTemplate.postForLocation("http://localhost:" + port + "/vendingMachine/insertCoin", Coin.DIME);
		restTemplate.postForLocation("http://localhost:" + port + "/vendingMachine/insertCoin", Coin.DIME);
		restTemplate.postForLocation("http://localhost:" + port + "/vendingMachine/insertCoin", Coin.DIME);

		restTemplate.postForLocation("http://localhost:" + port + "/vendingMachine/selectProduct", ProductCode.C1);
		restTemplate.postForLocation("http://localhost:" + port + "/vendingMachine/insertCoin", Coin.QUARTER);
		restTemplate.postForLocation("http://localhost:" + port + "/vendingMachine/insertCoin", Coin.QUARTER);
	}

}
