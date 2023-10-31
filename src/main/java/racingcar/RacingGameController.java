package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingGameController {
  private final CarView carView;

  public RacingGameController(CarView carView) {
    this.carView = carView;
  }

  public void runGame() {
    List<Car> cars = createCars();
    int tryCount = getTryCount();
    System.out.println("실행 결과");
    for (int i = 0; i < tryCount; i++) {
      moveCars(cars);
      carView.printStatus(cars);
      System.out.println();
    }
    List<String> winners = getWinners(cars);
    carView.printWinners(winners);
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

  private int getTryCount() {
    System.out.println("시도할 횟수는 몇 회인가요?");
    return Integer.parseInt(Console.readLine());
  }

  private void moveCars(List<Car> cars) {
    for (Car car : cars) {
      int randomNumber = Randoms.pickNumberInRange(0, 9);
      if (randomNumber >= 4) {
        car.moveForward();
      }
    }
  }

  private List<String> getWinners(List<Car> cars) {
    int maxPosition = getMaxPosition(cars);
    List<String> winners = new ArrayList<>();
    for (Car car : cars) {
      if (car.getPosition() == maxPosition) {
        winners.add(car.getName());
      }
    }
    return winners;
  }

  private int getMaxPosition(List<Car> cars) {
    int maxPosition = 0;
    for (Car car : cars) {
      maxPosition = Math.max(maxPosition, car.getPosition());
    }
    return maxPosition;
  }

}
