package racingcar.utils;

import racingcar.model.Car;

public class Validation {

  public static void isBlank(String name) {
    if(name == null || name.trim().isEmpty()) throw new IllegalArgumentException("공백이나 스페이스바가 있어요");
  }

  public static void isLengthError(String name) {
    if(name.length() > 5) throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
  }

  public static void isDuplicated(String name, Car[] car) {
    for (Car c : car) {
      if (c != null && c.getName().equals(name)) {
        throw new IllegalArgumentException("동일한 이름이 있다.");
      }
    }
  }

  public static int isNumber(String inputNum) {
    try {
      int num = Integer.parseInt(inputNum);
      return num;
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("숫자가 아닙니다.");
    }
  }



}
