package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import validation.StringValidator;

public class Game {
  public static List<Car> makeCarList(String nameList) {
    List<Car> carList = new ArrayList<Car>();
    StringTokenizer nameTokenizer = new StringTokenizer(nameList, ",");

    while(nameTokenizer.hasMoreTokens()) {
      String carName = StringValidator.validateStringLengthOver(nameTokenizer.nextToken(), 5);
      Car carListElement = new Car(carName);
      carList.add(carListElement);
    }

    return carList;
  }
}
