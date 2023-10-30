package racingcar.util;

import java.util.ArrayList;
import java.util.List;
import racingcar.validator.RacingCarNameValidator;

public class ConvertUtils {
  private static final RacingCarNameValidator validator = new RacingCarNameValidator();

  public static List<String> convertStringToList(String inputCarName) {
    List<String> validData = new ArrayList<>();
    for (String splitData : inputCarName.split(",")) {
      validator.validate(splitData);
      validData.add(splitData);
    }
    return validData;
  }

  public static int convertStringToInt(String inputString) {
    return Integer.parseInt(inputString);
  }
}
