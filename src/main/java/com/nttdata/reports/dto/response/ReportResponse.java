package com.nttdata.reports.dto.response;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Report object.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReportResponse {
	 private String firstName;
	 private String lastName;
	 private String documentNumber;
	 private String number;
	 private BigDecimal balance = BigDecimal.valueOf(0);

}
