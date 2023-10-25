package ru.shatalov.redacted.util.output.helpers;

import org.springframework.http.ResponseEntity;
import ru.shatalov.redacted.model.ResultData;

public interface OutputHandler {

  ResponseEntity<?> generate(ResultData resultData);
}
