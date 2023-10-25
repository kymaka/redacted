package ru.shatalov.redacted.util.output.helpers;

import ru.shatalov.redacted.model.enumeration.DataDestination;
import ru.shatalov.redacted.repository.ResultRepository;

public class OutputFactory {

  public OutputHandler getOutputHandler(DataDestination dist, ResultRepository repository) {
    return switch (dist) {
      case DataDestination.json -> new JsonHandler();
      case DataDestination.html -> new HtmlHandler();
      case DataDestination.db -> new DbHelper(repository);
    };
  }
}
