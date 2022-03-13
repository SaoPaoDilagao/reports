package com.nttdata.reports.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.reports.exceptions.customs.CustomInformationException;
import com.nttdata.reports.exceptions.customs.CustomNotFoundException;
import com.nttdata.reports.exceptions.customs.CustomResult;

/**
 * Global exception controller.
 */
@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionController {
  /**
   * Returns a JSON object with an error message.
   *
   * @return CustomInformationException
   */
  @ExceptionHandler
  public ResponseEntity<CustomResult> handle(CustomInformationException ex) {
    CustomResult customResult = new CustomResult();
    customResult.setMessage(ex.getMessage());
    return ResponseEntity.status(HttpStatus.CONFLICT).body(customResult);
  }

  /**
   * Returns a JSON object with an error message.
   *
   * @return CustomNotFoundException
   */
  @ExceptionHandler
  public ResponseEntity<CustomResult> handle(CustomNotFoundException ex) {
    CustomResult customResult = new CustomResult();
    customResult.setMessage(ex.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customResult);
  }
}
