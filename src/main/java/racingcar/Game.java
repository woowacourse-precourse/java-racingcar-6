package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import tool.Random;
import validation.StringValidator;


public class Game {

  public static List<Car> makeCarList(final String nameList) {
    List<Car> carList = new ArrayList<>();
    StringTokenizer nameTokenizer = new StringTokenizer(nameList, ",");

    while (nameTokenizer.hasMoreTokens()) {
      String carName = StringValidator.checkLengthOver(nameTokenizer.nextToken(), Const.CAR_NAME_LIMIT);
      Car carListElement = new Car(carName);
      carList.add(carListElement);
    }

    return carList;
  }

  public static List<Car> moveCars(final List<Car> carList) {
    for (Car car : carList) {
      if(Random.isRandOverValueInRange(Const.RANDOM_RANGE_BEGIN, Const.RANDOM_RANGE_END, Const.FORWARD_MOVE_BOUND)) {
        car.addForwardDistance();
      }
    }

    return carList;
  }

  public static void printTrialResult(final List<Car> carList) {
    for(Car car : carList) {
      System.out.println(car.getStatus());
    }
    System.out.println();
  }
}
