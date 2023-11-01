package racingcar.validation;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Validator {

  //TODO 인터페이스를 만들어서 Count와 Name 분류

  public static final int MAX_LENGTH = 5;

  public void isNull(String value) {
    if (value.isEmpty()) {
      throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
    }
  }

  public void isContainLetter(String count) {
    if (!count.matches("^[0-9]+$")) {
      throw new IllegalArgumentException(ErrorMessage.CONTAIN_LETTER.getMessage());
    }
  }

  public void isNotNaturalNum(String count){
    double num = Double.parseDouble(count);
    if (num != (int)num) {
      throw new IllegalArgumentException(ErrorMessage.NOT_NATURAL_NUM.getMessage());
    }
    if (num <= 0) {
      throw new IllegalArgumentException(ErrorMessage.NOT_NATURAL_NUM.getMessage());
    }
  }

  public void isMaxLengthExceeded(List<String> nameList) {
    for (String name : nameList) {
      if ((name.length() > MAX_LENGTH)) {
        throw new IllegalArgumentException(ErrorMessage.INVALID_LENGTH.getMessage());
      }
    }
  }

  public void isDuplicatedName(List<String> nameList) {
    for (int i = 0; i < nameList.size(); i++) {
      int count = Collections.frequency(nameList, nameList.get(i));
      if (count > 1) {
        throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NAME.getMessage());
      }
    }
  }

  public void isNullList(List<String> nameList) {
    if (nameList.isEmpty()) {
      throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
    }
  }

  public void isNullName(List<String> nameList) {
    for (String name : nameList) {
      if (name.isEmpty()) {
        throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
      }
    }
  }
}
