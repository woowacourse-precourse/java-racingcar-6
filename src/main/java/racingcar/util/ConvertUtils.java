package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.exception.RacingCarGameException;
import racingcar.validator.RacingCarNameValidator;

public class ConvertUtils {

  private static final RacingCarNameValidator validator = new RacingCarNameValidator();

  public static List<String> convertStringToList(String inputCarName) {
    return new ArrayList<>(Arrays.asList(inputCarName.split(",")));

  }

  public static int convertStringToInt(String inputString) {
    if (Long.parseLong(inputString) > Integer.MAX_VALUE) {
      throw new RacingCarGameException("라운드 횟수는 INT_MAXVALUE보다 클 수 없습니다.");
    }
    Integer input = Integer.parseInt(inputString);
    if (input < 0) {
      throw new RacingCarGameException("라운드 횟수는 0보다 작거나 같을 수 없습니다.");
    }
    return input;
  }
}