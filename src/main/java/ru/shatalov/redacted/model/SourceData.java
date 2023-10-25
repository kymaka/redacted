package ru.shatalov.redacted.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class SourceData {

  public SourceData() {}

  public SourceData(long num) {
    this.num = num;
  }

  @Id
  @GeneratedValue
  private long id;

  private long num;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getNum() {
    return num;
  }

  public void setNum(long value) {
    this.num = value;
  }
}
