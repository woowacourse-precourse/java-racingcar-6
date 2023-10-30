package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import validation.StringValidator;

public class Game {

  public static List<Car> makeCarList(final String nameList) {
    List<Car> carList = new ArrayList<>();
    StringTokenizer nameTokenizer = new StringTokenizer(nameList, ",");

    while (nameTokenizer.hasMoreTokens()) {
      String carName = StringValidator.checkLengthOver(nameTokenizer.nextToken(), 5);
      Car carListElement = new Car(carName);
      carList.add(carListElement);
    }

    return carList;
  }

  public static List<Car> moveCars(final List<Car> carList) {
    for (Car car : carList) {

    }

    return carList;
  }

  public static void play() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    String input = Console.readLine();
    List<Car> carList = makeCarList(input);

    System.out.println("시도할 회수는 몇회인가요?");
    int trialNumber = Integer.parseInt(
        StringValidator.checkIntegerFormat(Console.readLine()));

    while (trialNumber-- > 0) {

    }
  }
}
