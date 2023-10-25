package ru.shatalov.redacted.util.parser.helpers;

import ru.shatalov.redacted.model.NumbersArray;
import ru.shatalov.redacted.model.SourceData;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

class JsonDataParser implements DataParser {
  @Override
  public List<SourceData> parse(String[] numStrings, Optional<NumbersArray> args) {
    LinkedList<SourceData> nums = new LinkedList<>();
    if (args.isPresent()) {
      if (args.get().nums() != null) {
        for (long num : args.get().nums()) {
          nums.add(new SourceData(num));
        }
        return nums;
      } else {
        return null;
      }
    } else {
      return null;
    }
  }
}
