package racingcar.exception;

public class RacingCarGameException extends IllegalArgumentException {

  public RacingCarGameException() {

  }

  public RacingCarGameException(final String errorMessage) {
    super(errorMessage);
  }
}
