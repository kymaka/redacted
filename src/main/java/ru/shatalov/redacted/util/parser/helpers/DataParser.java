package ru.shatalov.redacted.util.parser.helpers;

import java.util.List;
import java.util.Optional;
import ru.shatalov.redacted.model.NumbersArray;
import ru.shatalov.redacted.model.SourceData;

public interface DataParser {
  List<SourceData> parse(String[] numStrings, Optional<NumbersArray> args);
}
