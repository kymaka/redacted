package ru.shatalov.redacted.service;

import org.springframework.stereotype.Service;
import ru.shatalov.redacted.model.ResultData;
import ru.shatalov.redacted.model.SourceData;

import java.util.List;

@Service
public class CalculatorService {

  public ResultData add(List<SourceData> nums) {
    long value = 0;
    for (SourceData num : nums) {
      value += num.getNum();
    }
    ResultData resultData = new ResultData();
    resultData.setNum(value);
    return resultData;
  }

  public ResultData mul(List<SourceData> nums) {
    long value = 1;
    for (SourceData num : nums) {
      value *= num.getNum();
    }
    return new ResultData(value);
  }

  public ResultData mulAdd(long a, long b, long c) {
    return new ResultData(a * b + c);
  }

  public ResultData lcm(long a, long b) {
    return new ResultData(a * b / gcd(a, b));
  }

  private long gcd(long a, long b) {
    if (b == 0) {
      return a;
    } else {
      return gcd(b, a % b);
    }
  }
}
