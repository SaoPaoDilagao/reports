package com.nttdata.reports.service;

import com.nttdata.reports.dto.response.AccountResponse;

import reactor.core.publisher.Flux;

/**
 * Account service interface.
 */
public interface AccountService {
	Flux<AccountResponse> getAccountsByClientDocumentNumber( String documentNumber);
  
}
