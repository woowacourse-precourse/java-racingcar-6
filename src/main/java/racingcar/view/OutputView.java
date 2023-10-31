package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {

  private static final String MOVEMENT_SYMBOL = "-";

  public void displayCarName() {
    System.out.println(OutputMessage.CAR_NAME_PROMPT.getMessage());
  }

  public void displayGameCount() {
    System.out.println(OutputMessage.GAME_COUNT_PROMPT.getMessage());
  }

  public void displayStart() {
    System.out.println(OutputMessage.RESULT_HEADER.getMessage());
  }

  public void displayMovement(List<Car> carList) {
    for (Car car : carList) {
      System.out.println(car.getName() + " : " + MOVEMENT_SYMBOL.repeat(car.getMovement()));
    }
    System.out.println();
  }
}
