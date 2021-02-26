package br.com.pierredev.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.pierredev.hrpayroll.entities.Payment;
import br.com.pierredev.hrpayroll.entities.Worker;

@Service
public class PaymentService {
	
	@Value("${hr-worker.host}")
	private String workerHost;
	
	@Autowired
	private RestTemplate resteRestTemplate;
	
	public Payment getPayment(long workerId, int days) {
		Map<String, String>  uriVariables = new HashMap<>();
		uriVariables.put("id", "" + workerId);
		
		Worker worker = resteRestTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);
	    return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}

}
