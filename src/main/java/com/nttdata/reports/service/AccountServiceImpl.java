package com.nttdata.reports.service;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.nttdata.reports.dto.response.AccountResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * Account service implementation.
 */
@Service
public class AccountServiceImpl implements AccountService {
  @Value("${backend.service.account}")
  private String urlAccount;

  @Autowired
  @Qualifier("wcLoadBalanced")
  private WebClient.Builder webClient;

	@Override
	public Flux<AccountResponse> getAccountsByClientDocumentNumber(String documentNumber) {
		return webClient
		        .build()
		        .get()
		        .uri(urlAccount + "/get/client/documentNumber/{documentNumber}", documentNumber)
		        .retrieve()
		        //.onStatus(NOT_FOUND::equals, response -> Mono
		         //   .error(new CustomNotFoundException("Account " + number + " not found")))
		        .bodyToFlux(AccountResponse.class);
	}
}
