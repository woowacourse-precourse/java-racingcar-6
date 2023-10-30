package racingcar.model;

import racingcar.util.ValidationCarName;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Car {
  private final String name;

  public Car() {
    String carName;

    while (true) {
      OutputView.printSetCarName();
      carName = InputView.setCarName();

      if (ValidationCarName.isValidCarName(carName)) {
        this.name = carName;
        return;
      }
    }

  }

  public String getName() {
    return name;
  }
}
