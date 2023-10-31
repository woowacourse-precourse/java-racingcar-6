package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class View {
  static public void printGameStart() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
  }

  static public List<String> inputCars() {
    String input = Console.readLine();
    List<String> cars = Arrays.asList(input.split(","));
    System.out.println(cars);
    return cars;
  }
}
