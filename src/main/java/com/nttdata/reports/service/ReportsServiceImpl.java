package com.nttdata.reports.service;

import org.springframework.stereotype.Service;

import com.nttdata.reports.dto.response.ReportResponse;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;


@Service
@RequiredArgsConstructor
public class ReportsServiceImpl implements ReportsService {

	private final AccountService accountService;
	private final CreditService creditService;
	
	@Override
	public Flux<ReportResponse> clientConsolidated(String documentNumber) {
		
		Flux<ReportResponse> fluxFromCredits = creditService.getCreditsByClientDocumentNumber(documentNumber)
				.flatMap( elem -> {
					ReportResponse temp = new ReportResponse();
					
					temp.setFirstName(elem.getClient().getFirstName());
					temp.setLastName(elem.getClient().getLastName());
					temp.setDocumentNumber(elem.getClient().getDocumentNumber());
					temp.setNumber(elem.getNumber());
					temp.setBalance(elem.getCreditBalance());
					
					return Flux.just(temp);
				});
				
				
		Flux<ReportResponse> fluxFromAccounts  = accountService.getAccountsByClientDocumentNumber(documentNumber)
				.flatMap( elem -> {
					ReportResponse temp = new ReportResponse();
					
					temp.setFirstName(elem.getClient().getFirstName());
					temp.setLastName(elem.getClient().getLastName());
					temp.setDocumentNumber(elem.getClient().getDocumentNumber());
					temp.setNumber(elem.getNumber());
					temp.setBalance(elem.getBalance());
					
					return Flux.just(temp);
				});
		
		
		return Flux.merge(fluxFromCredits,fluxFromAccounts);
	}

}
