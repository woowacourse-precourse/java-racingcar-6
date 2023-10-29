package racingcar.utils;

import java.util.List;
import racingcar.model.Car;
import racingcar.view.ErrorView;

public class Validation {


  public static void isBlank(String name) {
    if(name == null || name.trim().isEmpty()) ErrorView.isBlankError();
  }

  public static void isLengthError(String name) {
    if(name.length() > 5) ErrorView.isLengthError();
  }

  public static void isDuplicated(String name, List<Car> car) {
    for (Car c : car) {
      if (c != null && c.getName().equals(name)) {
        ErrorView.isDuplicatedError();
      }
    }
  }

  public static int isNumber(String inputNum) {
    try {
      int num = Integer.parseInt(inputNum);
      return num;
    } catch (NumberFormatException e) {
      return ErrorView.isNumber();
    }
  }



}
