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

  /**
   * 라운드를 실행하고 차량의 이동 상황을 출력
   */
  public void play() {
    racingCars.moveCars();
    output.printCurrentPositions(racingCars.getCarNames(), racingCars.getCarPositions());
  }
}
