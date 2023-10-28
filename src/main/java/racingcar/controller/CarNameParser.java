package racingcar.controller;

import java.util.Arrays;
import java.util.List;

public class CarNameParser {
  public  String[] carNamesToArray(String carNames) {
    return carNames.split(",");
  }

  public static List<String> carNameToList(String[] carNamesArray) {
    List<String> carNamesList = Arrays.asList(carNamesArray);
    return carNamesList;
  }
}
