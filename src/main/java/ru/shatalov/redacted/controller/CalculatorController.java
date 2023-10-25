package ru.shatalov.redacted.controller;

import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shatalov.redacted.model.NumbersArray;
import ru.shatalov.redacted.model.ResultData;
import ru.shatalov.redacted.model.SourceData;
import ru.shatalov.redacted.repository.ResultRepository;
import ru.shatalov.redacted.repository.SourceRepository;
import ru.shatalov.redacted.service.CalculatorService;
import ru.shatalov.redacted.util.output.OutputGenerator;
import ru.shatalov.redacted.util.parser.Parser;

@RestController
@RequestMapping(path = "/calculate")
public class CalculatorController {

  private final CalculatorService calculatorService;
  private final SourceRepository sourceRepository;
  private final ResultRepository resultRepository;
  private final Parser parser;
  private final OutputGenerator outputGenerator;

  public CalculatorController(
      CalculatorService calculatorService,
      SourceRepository sourceRepository,
      ResultRepository resultRepository) {
    this.calculatorService = calculatorService;
    this.sourceRepository = sourceRepository;
    this.resultRepository = resultRepository;
    this.parser = new Parser();
    this.outputGenerator = new OutputGenerator();
  }

  @PostMapping(path = "/add/{source}/{dist}/{*nums}")
  public ResponseEntity<?> calculateAdd(
      @PathVariable(name = "source") String source,
      @PathVariable(name = "dist") String destination,
      @RequestBody Optional<NumbersArray> args,
      @PathVariable(name = "nums") String[] numsString) {
    if (parser.parseInputSource(source)) {
      List<SourceData> nums = parser.parseValues(numsString, args, sourceRepository);
      ResultData resultData = calculatorService.add(nums);

      if (outputGenerator.parseOutputDist(destination)) {
        return outputGenerator.generateOutput(resultData, resultRepository);
      }
    }
    return new ResponseEntity<>("ERROR", HttpStatus.BAD_REQUEST);
  }

  @PostMapping(path = "/mul/{source}/{dist}/{*nums}")
  public ResponseEntity<?> calculateMul(
      @PathVariable(name = "source") String source,
      @PathVariable(name = "dist") String destination,
      @RequestBody Optional<NumbersArray> args,
      @PathVariable(name = "nums") String[] numsString) {

    if (parser.parseInputSource(source)) {
      List<SourceData> nums = parser.parseValues(numsString, args, sourceRepository);
      ResultData resultData = calculatorService.mul(nums);

      if (outputGenerator.parseOutputDist(destination)) {
        return outputGenerator.generateOutput(resultData, resultRepository);
      }
    }
    return new ResponseEntity<>("ERROR", HttpStatus.BAD_REQUEST);
  }

  @PostMapping(path = "/mulAdd/{source}/{dist}/{*nums}")
  public ResponseEntity<?> calculateMulAdd(
      @PathVariable(name = "source") String source,
      @PathVariable(name = "dist") String destination,
      @RequestBody Optional<NumbersArray> args,
      @PathVariable(name = "nums") String[] numsString) {

    if (parser.parseInputSource(source)) {
      List<SourceData> nums = parser.parseValues(numsString, args, sourceRepository);
      ResultData resultData =
          calculatorService.mulAdd(
              nums.get(0).getNum(), nums.get(1).getNum(), nums.get(2).getNum());

      if (outputGenerator.parseOutputDist(destination)) {
        return outputGenerator.generateOutput(resultData, resultRepository);
      }
    }
    return new ResponseEntity<>("ERROR", HttpStatus.BAD_REQUEST);
  }

  @PostMapping(path = "/lcm/{source}/{dist}/{*nums}")
  public ResponseEntity<?> calculateLcm(
      @PathVariable(name = "source") String source,
      @PathVariable(name = "dist") String destination,
      @RequestBody Optional<NumbersArray> args,
      @PathVariable(name = "nums") String[] numsString) {

    if (parser.parseInputSource(source)) {
      List<SourceData> nums = parser.parseValues(numsString, args, sourceRepository);
      ResultData resultData = calculatorService.lcm(nums.get(0).getNum(), nums.get(1).getNum());

      if (outputGenerator.parseOutputDist(destination)) {
        return outputGenerator.generateOutput(resultData, resultRepository);
      }
    }
    return new ResponseEntity<>("ERROR", HttpStatus.BAD_REQUEST);
  }
}
