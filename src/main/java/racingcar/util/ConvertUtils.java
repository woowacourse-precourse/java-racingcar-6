package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.validator.RacingCarNameValidator;

public class ConvertUtils {

  private static final RacingCarNameValidator validator = new RacingCarNameValidator();

  public static List<String> convertStringToList(String inputCarName) {
    return new ArrayList<>(Arrays.asList(inputCarName.split(",")));

  }

  public static int convertStringToInt(String inputString) {
    return Integer.parseInt(inputString);
  }
}
