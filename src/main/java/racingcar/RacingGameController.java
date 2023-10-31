package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class RacingGameController {
  private final CarView carView;

  public RacingGameController(CarView carView) {
    this.carView = carView;
  }

  public void runGame() {
    List<Car> cars = createCars();
  }

  private List<Car> createCars() {
    System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
    String input = Console.readLine();
    String[] carNames = input.split(",");
    List<Car> cars = new ArrayList<>();
    for (String name : carNames) {
      validateCarName(name);
      cars.add(new Car(name.trim()));
    }

    return cars;
  }

  private void validateCarName(String name) {
    if (name.length() > 5) {
      throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
    }
  }


}
