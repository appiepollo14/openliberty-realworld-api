package org.example.realworldapi.domain.exception;

import static java.util.Collections.singletonList;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class BusinessException extends RuntimeException {
  private final int code;
  private final List<String> messages;

  public BusinessException(int code, String message) {
    super(message);
    this.code = code;
    this.messages = new LinkedList<>(singletonList(message));
  }

  public BusinessException(int code, List<String> messages) {
    super(String.join(", ", messages));
    this.code = code;
    this.messages = messages;
  }

  public int getCode() {
    return this.code;
  }

  public List<String> getMessages() {
    return this.messages;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof BusinessException that)) return false;
    return getCode() == that.getCode() && Objects.equals(getMessages(), that.getMessages());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCode(), getMessages());
  }

  @Override
  public String toString() {
    return "BusinessException(code=" + this.getCode() + ", messages=" + this.getMessages() + ")";
  }
}
