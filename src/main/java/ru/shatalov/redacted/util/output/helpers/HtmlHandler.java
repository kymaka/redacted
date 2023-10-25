package ru.shatalov.redacted.util.output.helpers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import ru.shatalov.redacted.model.ResultData;

public class HtmlHandler implements OutputHandler {
  @Override
  public ResponseEntity<?> generate(ResultData resultData) {
    String html = "<html><body><h1>" + resultData.getNum() + "</h1></body></html>";
    return ResponseEntity.ok().contentType(MediaType.TEXT_HTML).body(html);
  }
}
