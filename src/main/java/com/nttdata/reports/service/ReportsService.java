package com.nttdata.reports.service;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.PathVariable;

import reactor.core.publisher.Mono;

public interface ReportsService {
	Mono<BigDecimal> clientConsolidated(@PathVariable String documentNumber);

}
