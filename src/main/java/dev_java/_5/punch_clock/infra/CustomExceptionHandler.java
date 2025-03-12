package dev_java._5.punch_clock.infra;

public class CustomExceptionHandler extends RuntimeException {
  public CustomExceptionHandler(String message) {
    super(message);
  }
  @Override
  public synchronized Throwable fillInStackTrace() {
    return this;
  }
}
