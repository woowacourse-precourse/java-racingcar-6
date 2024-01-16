package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserConsole {

  public final int MIN_CAR_NUMBER = 2;
  public final int MIN_ROUNDS_NUMBER = 1;

  public List<Car> makingCarLineUp() {
    List<String> carNames = makingCarNames();
    List<Car> carLineUp = new ArrayList<>();
    for (int i = 0; i < carNames.size(); i++) {
      Car car = new Car(carNames.get(i));
      carLineUp.add(car);
    }
    return carLineUp;
  }

  public List<String> makingCarNames() {
    System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
    String carName = Console.readLine();
    List<String> carNames = Arrays.asList(carName.split(","));
    if (carNames.size() < MIN_CAR_NUMBER) {
      throw new IllegalArgumentException();
    }
    return carNames;
  }

  public int askRounds() {
    System.out.println("시도할 횟수는 몇회인가요?");
    String input = Console.readLine();
    int rounds = validateRounds(input);
    return rounds;
  }

  public int validateRounds(String input) {
    int rounds = Integer.parseInt(input);
    if (rounds < MIN_ROUNDS_NUMBER) {
      throw new IllegalArgumentException();
    }
    return rounds;
  }

  public static void printRaceStatus(String status) {
    System.out.println(status);
  }

  public static void printWinners(List<String> winners) {
    String result = String.join(", ", winners);
    System.out.println("최종 우승자 : " + result);
  }
}
