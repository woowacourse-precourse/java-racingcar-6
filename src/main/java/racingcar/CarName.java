package racingcar;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class CarName {
  public List<String> getCarNames() {
    System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분합니다)");
    String input = Console.readLine();
    List<String> carNames = splitAndTrimNames(input);
    exception_Length(carNames);
    return carNames;
  }

  private List<String> splitAndTrimNames(String input) {
    String[] nameArray = input.split(",");
    List<String> carNames = new ArrayList<>();
    for (String name : nameArray) {
      carNames.add(name.trim());
    }
    return carNames;
  }

  private void exception_Length(List<String> carNames) {
    for (String name : carNames) {
      if (name.length() > 5) {
        throw new IllegalArgumentException("5자 이하로 입력하세요.");
      }
    }
  }
}
