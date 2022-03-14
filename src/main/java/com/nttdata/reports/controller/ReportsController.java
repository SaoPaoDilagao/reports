package com.nttdata.reports.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.reports.dto.response.ReportResponse;
import com.nttdata.reports.service.ReportsService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reports")
public class ReportsController {
	
	private final ReportsService reportsService;
	
	@GetMapping("/clientConsolidated/{documentNumber}")
	public Flux<ReportResponse> clientConsolidated(@PathVariable String documentNumber){
		
		return reportsService.clientConsolidated(documentNumber);
	}

}
