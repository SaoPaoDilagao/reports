package com.nttdata.reports.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/reports")
public class ReportsController {
	
	@GetMapping("/clientConsolidated/{documentNumber}")
	public Mono<BigDecimal> clientConsolidated(@PathVariable String documentNumber){
		
		
		return null;
		
	}

}
