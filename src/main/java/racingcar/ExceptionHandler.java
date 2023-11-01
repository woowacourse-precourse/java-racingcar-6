package racingcar;

import java.util.Arrays;
import java.util.List;

public class ExceptionHandler {

  public List<String> carNameException(String input) {
    if (input.isEmpty()) {
      throw new IllegalArgumentException("아무것도 입력하지 않았습니다.");
    }
    List<String> cars = Arrays.asList(input.split(","));
    for (String car : cars) {
      if (car.length() > 5) {
        throw new IllegalArgumentException("자동차의 이름이 5자가 넘어갑니다.");
      }
      if (!car.chars().allMatch(Character::isAlphabetic)) {
        throw new IllegalArgumentException("이름에 알파벳 이외의 문자가 포함되어 있습니다.");
      }
    }
    return cars;
  }

}
