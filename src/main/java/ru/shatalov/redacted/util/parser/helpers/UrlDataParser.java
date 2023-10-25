package ru.shatalov.redacted.util.parser.helpers;

import ru.shatalov.redacted.model.NumbersArray;
import ru.shatalov.redacted.model.SourceData;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

class UrlDataParser implements DataParser {
  @Override
  public List<SourceData> parse(String[] numStrings, Optional<NumbersArray> args) {
    LinkedList<SourceData> nums = new LinkedList<>();
    String[] numString = numStrings[0].split("/");
    for (int i = 1; i < numString.length; i++) {
      nums.add(new SourceData(Long.parseLong(numString[i])));
    }
    return nums;
  }
}
