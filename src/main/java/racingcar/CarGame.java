package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class CarGame {
  private List<Car> cars;
  private Integer attempts;
  public CarGame() {
    cars = new ArrayList<Car>();
    attempts = 0;
  }

  public void prompt() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    String names = readLine();
    this.cars = Arrays.stream(names.split(",")).map((String name) -> new Car(name)).collect(Collectors.toList());
    System.out.println("시도할 회수는 몇회인가요?");
    String attemptsInput = readLine();
    this.attempts = Integer.parseInt(attemptsInput);
    if(attempts < 0) throw new IllegalArgumentException();
  }

  private void playOneTime() {
    for(Car car : cars) {
      if(pickNumberInRange(0,9) < 4) continue;
      car.goForward();
    }
  }

  private void printCurrentStatus() {
    for(Car car : cars) {
      System.out.println(car);
    }
    System.out.println();
  }

}
