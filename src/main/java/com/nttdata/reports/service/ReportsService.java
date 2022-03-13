package com.nttdata.reports.service;

import org.springframework.web.bind.annotation.PathVariable;

import com.nttdata.reports.dto.response.ReportResponse;

import reactor.core.publisher.Flux;

public interface ReportsService {
	Flux<ReportResponse> clientConsolidated(@PathVariable String documentNumber);

}
