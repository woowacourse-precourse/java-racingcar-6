package racingcar.view;

import racingcar.domain.Car;
import racingcar.service.RaceGameService;

import java.util.List;

public class OutputView {

  public void printRaceResult() {
    for (Car car : RaceGameService.getCars()) {
      System.out.println(car.getCarName() + " : " + "-".repeat(car.getProgressCount()));
    }
    System.out.println();
  }

  public void printGameWon(String winners) {
    System.out.println("최종 우승자 : " + winners);
  }
}