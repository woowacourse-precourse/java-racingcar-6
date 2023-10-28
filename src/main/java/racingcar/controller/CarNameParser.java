package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.validator.CarNameValidator;

public class CarNameParser {

  private static CarNameValidator carNameValidator;

  public CarNameParser() {
    carNameValidator = new CarNameValidator();
  }

  public  String[] carNamesToArray(String carNames) {
    return carNames.split(",");
  }

  public static List<String> carNameToList(String[] carNamesArray) {
    List<String> carNamesList = Arrays.asList(carNamesArray);
    carNameValidator.isNameLengthValid(carNamesList);
    carNameValidator.isNameDuplicate(carNamesList);
    carNameValidator.isNumberOfCarsValid(carNamesList);
    carNameValidator.isNameValid(carNamesList);
    return carNamesList;
  }
}
