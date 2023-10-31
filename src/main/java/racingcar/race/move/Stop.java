package racingcar.race.move;

public record Stop(int number) implements Movement {

  @Override
  public int getNumber() {
    return number;
  }
}
