package racingcar.race.move;

public record Go(int number) implements Movement {

  @Override
  public int getNumber() {
    return number;
  }
}
