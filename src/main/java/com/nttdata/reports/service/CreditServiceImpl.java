package com.nttdata.reports.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.nttdata.reports.dto.response.CreditResponse;

import reactor.core.publisher.Flux;



/**
 * Credit service implementation.
 */
@Service
public class CreditServiceImpl implements CreditService {
  @Value("${backend.service.credit}")
  private String urlCredit;

  @Autowired
  @Qualifier("wcLoadBalanced")
  private WebClient.Builder webClient;

	@Override
	public Flux<CreditResponse> getCreditsByClientDocumentNumber(String documentNumber) {
		
		return webClient
		        .build()
		        .get()
		        .uri(urlCredit + "/client/documentNumber/{documentNumber}", documentNumber)
		        .retrieve()
		        //.onStatus(NOT_FOUND::equals, response -> Mono
		        //   .error(new CustomNotFoundException("Credits " + number + " not found")))
		        .bodyToFlux(CreditResponse.class);
	}

  
}
