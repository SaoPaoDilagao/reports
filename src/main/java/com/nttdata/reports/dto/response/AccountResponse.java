package com.nttdata.reports.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Account object.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountResponse {
  private String id;
  private String number;
  private ClientResponse client;
  private TypeAccountResponse typeAccount;
  private List<String> holders;
  private List<String> signatories;
  private BigDecimal balance = BigDecimal.valueOf(0);
  private boolean status;
}
