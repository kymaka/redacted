package ru.shatalov.redacted.util.output;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.shatalov.redacted.model.ResultData;
import ru.shatalov.redacted.model.enumeration.DataDestination;
import ru.shatalov.redacted.repository.ResultRepository;
import ru.shatalov.redacted.util.output.helpers.OutputFactory;
import ru.shatalov.redacted.util.output.helpers.OutputHandler;

public class OutputGenerator {

  DataDestination dist;
  OutputFactory outputFactory;

  public OutputGenerator() {
    this.outputFactory = new OutputFactory();
  }

  public boolean parseOutputDist(String dist) {
    try {
      this.dist = DataDestination.valueOf(dist);
      return true;
    } catch (IllegalArgumentException e) {
      return false;
    }
  }

  public ResponseEntity<?> generateOutput(ResultData resultData, ResultRepository repository) {
    OutputHandler handler = outputFactory.getOutputHandler(dist, repository);
    return handler != null
        ? handler.generate(resultData)
        : new ResponseEntity<>("ERROR", HttpStatus.BAD_REQUEST);
  }
}
