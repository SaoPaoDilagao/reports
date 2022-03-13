package com.nttdata.reports.service;



import com.nttdata.reports.dto.response.CreditResponse;

import reactor.core.publisher.Flux;

/**
 * Credit service interface.
 */
public interface CreditService {
	
	Flux<CreditResponse> getCreditsByClientDocumentNumber(String documentNumber);
  
}
