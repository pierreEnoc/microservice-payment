package br.com.pierredev.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pierredev.hrpayroll.entities.Payment;
import br.com.pierredev.hrpayroll.entities.Worker;
import br.com.pierredev.hrpayroll.feignClient.WorkerFeignClient;

@Service
public class PaymentService {
	
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(long workerId, int days) {
				
		Worker worker = workerFeignClient.findById(workerId).getBody();
	    return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}

}
