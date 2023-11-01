package racingcar.IO.Input;

public class ValidatedRoundCount {

  private final int racingCount;

  private ValidatedRoundCount(int racingCount) {
    this.racingCount = racingCount;
  }

  public static ValidatedRoundCount of(String input) {
    if (!input.matches("\\d+")) {
      throw new IllegalArgumentException("숫자만 입력 가능합니다.");
    }
    int racingCount = Integer.parseInt(input);
    if (racingCount < 1 || racingCount > 100) {
      throw new IllegalArgumentException("경주 횟수는 1 이상 이어야 합니다.");
    }
    return new ValidatedRoundCount(racingCount);
  }

  public int getRacingCount() {
    return racingCount;
  }
}
