package br.com.pierredev.hrpayroll.services;

import org.springframework.stereotype.Service;

import br.com.pierredev.hrpayroll.entities.Payment;

@Service
public class PaymentService {
	
	public Payment getPayment(long workerId, int days) {
		return new Payment("Bob", 200.0, days);
	}

}
