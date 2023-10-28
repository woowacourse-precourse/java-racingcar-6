package racingcar.validator;

import java.util.HashSet;
import java.util.Set;

public class CarNameValidator {

  public void isNameLengthValid(String[] carNamesList) throws IllegalArgumentException {
    for (String carName : carNamesList) {
      if (carName.length() > 5 ) {
        throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
      }
    }
  }
}
