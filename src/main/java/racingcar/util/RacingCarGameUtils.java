package racingcar.util;

import static racingcar.constant.ExceptionConstants.NEGATIVE_NUMBER_ROUNDCOUNT;
import static racingcar.constant.ExceptionConstants.OVER_INTMAX_ROUNDCOUNT;
import static racingcar.constant.RacingCarGameConfig.RANDOM_MAXIMUM_VALUE;
import static racingcar.constant.RacingCarGameConfig.RANDOM_MINIMUM_VALUE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.exception.RacingCarGameException;

public class RacingCarGameUtils {

  public static List<String> convertStringToList(final String inputCarName) {
    return new ArrayList<>(Arrays.asList(inputCarName.split(",")));

  }

  public static int convertStringToInt(final String inputString) {
    if (Long.parseLong(inputString) > Integer.MAX_VALUE) {
      throw new RacingCarGameException(OVER_INTMAX_ROUNDCOUNT);
    }
    Integer input = Integer.parseInt(inputString);
    if (input < 0) {
      throw new RacingCarGameException(NEGATIVE_NUMBER_ROUNDCOUNT);
    }
    return input;
  }

  public static List<Integer> generateRandomValuesForCarGame(final Integer carsCount) {
    List<Integer> randomList = new ArrayList<>();
    for (int i = 0; i < carsCount; i++) {
      randomList.add(Randoms.pickNumberInRange(RANDOM_MINIMUM_VALUE, RANDOM_MAXIMUM_VALUE));
    }
    return randomList;
  }
}