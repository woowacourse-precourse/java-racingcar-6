package racingcar.race;

public class ValidationRoundCount {

  private final int racingCount;

  private ValidationRoundCount(int racingCount) {
    this.racingCount = racingCount;
  }

  public static ValidationRoundCount of(int racingCount) {
    if (racingCount < 1) {
      throw new IllegalArgumentException("경주 횟수는 1 이상 이어야 합니다.");
    }
    return new ValidationRoundCount(racingCount);
  }

  public int getRacingCount() {
    return racingCount;
  }
}
