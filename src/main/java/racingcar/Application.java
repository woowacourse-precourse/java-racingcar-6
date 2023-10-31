package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
  public static void main(String[] args) {
    List<Car> cars = getCarsFromUser();
  }
  
  private static List<Car> getCarsFromUser() {
    System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
    String input = Console.readLine();
    return createCars(input.split(","));
  }
  
  private static List<Car> createCars(String[] carNames) {
    return Arrays.stream(carNames)
            .map(String::trim)
            .map(Car::new)
            .collect(Collectors.toList());
  }
}