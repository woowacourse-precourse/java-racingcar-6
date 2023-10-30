package racingcar.exception;

public class RacingCarGameException extends IllegalArgumentException {

  public RacingCarGameException() {

  }

  public RacingCarGameException(String errorMessage) {
    super(errorMessage);
  }
}
