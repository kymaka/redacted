package ru.shatalov.redacted.util.parser;

import ru.shatalov.redacted.model.NumbersArray;
import ru.shatalov.redacted.model.SourceData;
import ru.shatalov.redacted.model.enumeration.DataSource;
import ru.shatalov.redacted.repository.SourceRepository;
import ru.shatalov.redacted.util.parser.helpers.DataParser;
import ru.shatalov.redacted.util.parser.helpers.DataParserFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Parser {

  private DataSource src;
  private final DataParserFactory dataParserFactory;

  public Parser() {
    this.dataParserFactory = new DataParserFactory();
  }

  public boolean parseInputSource(String source) {
    try {
      src = DataSource.valueOf(source);
      return true;
    } catch (IllegalArgumentException e) {
      return false;
    }
  }

  public List<SourceData> parseValues(
      String[] numStrings, Optional<NumbersArray> args, SourceRepository repository) {
    DataParser dataParser = dataParserFactory.getDataParser(src, repository);
    return dataParser != null ? dataParser.parse(numStrings, args) : new LinkedList<>();
  }
}
