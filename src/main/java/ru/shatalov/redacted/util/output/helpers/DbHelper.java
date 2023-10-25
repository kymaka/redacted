package ru.shatalov.redacted.util.output.helpers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.shatalov.redacted.model.ResultData;
import ru.shatalov.redacted.repository.ResultRepository;

public class DbHelper implements OutputHandler {

  private final ResultRepository repository;

  public DbHelper(ResultRepository repository) {
    this.repository = repository;
  }

  @Override
  public ResponseEntity<?> generate(ResultData resultData) {
    return new ResponseEntity<>(repository.save(resultData), HttpStatus.OK);
  }
}
