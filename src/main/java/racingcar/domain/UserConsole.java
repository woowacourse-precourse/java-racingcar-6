package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserConsole {

  public final int MAX_NAME_LENGTH = 5;

  public List<Car> makingCarLineUp() {
    List<String> carNames;
    List<Car> carLineUp = new ArrayList<>();

    carNames = makingCarNames();
    for (int i = 0; i < carNames.size(); i++) {
      Car car = new Car(carNames.get(i));
      carLineUp.add(car);
    }

    return carLineUp;
  }

  public List<String> makingCarNames() {
    String carName;
    List<String> carNames;

    System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
    carName = Console.readLine();
    carNames = Arrays.asList(carName.split(","));
    validateCarNames(carNames);

    return carNames;
  }
  public void validateCarNames(List<String> carNames) {
    if (carNames.size() == 1) {
      throw new IllegalArgumentException();
    }
    for (int i = 0; i < carNames.size(); i++) {
      if (carNames.get(i).length() > MAX_NAME_LENGTH) {
        throw new IllegalArgumentException();
      }
      if (carNames.get(i).isBlank()) {
        throw new IllegalArgumentException();
      }
    }
  }

  public int askRounds() {
    int rounds;
    String input;

    System.out.println("시도할 횟수는 몇회인가요?");
    input = Console.readLine();
    rounds = Integer.parseInt(input);

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
