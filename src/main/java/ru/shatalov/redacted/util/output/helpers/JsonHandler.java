package ru.shatalov.redacted.util.output.helpers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import ru.shatalov.redacted.model.ResultData;

public class JsonHandler implements OutputHandler {

  @Override
  public ResponseEntity<?> generate(ResultData resultData) {
    return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(resultData);
  }
}
