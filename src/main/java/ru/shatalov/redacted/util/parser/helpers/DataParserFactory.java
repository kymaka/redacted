package ru.shatalov.redacted.util.parser.helpers;

import ru.shatalov.redacted.model.enumeration.DataSource;
import ru.shatalov.redacted.repository.SourceRepository;

public class DataParserFactory {
  public DataParser getDataParser(DataSource src, SourceRepository repository) {
    return switch (src) {
      case url -> new UrlDataParser();
      case json -> new JsonDataParser();
      case db -> new DbDataParser(repository);
    };
  }
}
