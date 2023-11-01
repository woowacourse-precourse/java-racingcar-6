package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.Output;

public class Round {
  private final Cars racingCars;
  private final Output output;

  public Round(Cars racingCars, Output output) {
    this.racingCars = racingCars;
    this.output = output;
  }

  public void play() {
    racingCars.moveCars();
    output.printCurrentPositions(racingCars.getCarNames(), racingCars.getCarPositions());
  }
}
