package racingcar.race.move;

public sealed interface Movement permits Go, Stop {

  int getNumber();
}

