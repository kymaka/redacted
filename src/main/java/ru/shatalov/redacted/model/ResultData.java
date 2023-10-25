package ru.shatalov.redacted.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ResultData {

  public ResultData() {}

  public ResultData(long num) {
    this.num = num;
  }

  @Id @GeneratedValue private long id;

  private long num;

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public long getNum() {
    return num;
  }

  public void setNum(long result) {
    this.num = result;
  }
}
