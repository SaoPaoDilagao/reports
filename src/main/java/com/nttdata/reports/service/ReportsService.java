package com.nttdata.reports.service;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.PathVariable;

import com.nttdata.reports.dto.response.ReportResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReportsService {
	Flux<ReportResponse> clientConsolidated(@PathVariable String documentNumber);

}
