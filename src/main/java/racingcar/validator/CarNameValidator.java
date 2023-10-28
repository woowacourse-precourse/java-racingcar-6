package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameValidator {

  public static void isNameLengthValid(List<String> carNamesList) throws IllegalArgumentException {
    for (String carName : carNamesList) {
      if (carName.length() > 5) {
        throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
      }
    }
  }

  public static void isNameDuplicate(List<String> carNamesList) throws IllegalArgumentException {
    Set<String> uniqueElements = new HashSet<>();
    for (String element : carNamesList) {
      if (uniqueElements.contains(element)) {
        throw new IllegalArgumentException("중복된 이름이 있습니다.");
      }
      uniqueElements.add(element);
    }
  }

  public static void isNumberOfCarsValid(List<String> carNamesList) throws IllegalArgumentException {
    if (carNamesList.size() < 2) {
      throw new IllegalArgumentException("2개 이상의 이름을 입력해주세요.");
    }
  }

  public static void isNameValid(List<String> carNamesList) throws IllegalArgumentException {
    for (String element : carNamesList) {
      if (element != null && element.trim().isEmpty()) {
        throw new IllegalArgumentException("공백을 입력하지 마세요.");
      }
    }
  }

}
