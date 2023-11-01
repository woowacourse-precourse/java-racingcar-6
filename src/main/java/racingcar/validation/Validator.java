package racingcar.validation;

import java.util.Collections;
import java.util.List;

public class Validator {

  public static final int MAX_LENGTH = 5;

  public void isContainNull(String value) {
    if (value.isEmpty()) {
      throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
    }
  }

  public void isContainLetter(String count) {
    if (!count.matches("^[0-9]+$")) {
      throw new IllegalArgumentException(ErrorMessage.CONTAIN_LETTER.getMessage());
    }
  }

  public void isNotPositiveNum(String count) {
    if (Integer.parseInt(count) <= 0) {
      throw new IllegalArgumentException(ErrorMessage..getMessage());
    }
  }

  //TODO 유리수 검정


  public void isMaxLengthExceeded(List<String> nameList) {
    for (int i = 0; i < nameList.size(); i++) {
      if ((nameList.get(i).length() > MAX_LENGTH)) {
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
}
