package ru.shatalov.redacted.util.parser.helpers;

import java.util.List;
import java.util.Optional;
import ru.shatalov.redacted.model.NumbersArray;
import ru.shatalov.redacted.model.SourceData;
import ru.shatalov.redacted.repository.SourceRepository;

class DbDataParser implements DataParser {

  private final SourceRepository repository;

  public DbDataParser(SourceRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<SourceData> parse(String[] numStrings, Optional<NumbersArray> args) {
    return repository.findAll();
  }
}
