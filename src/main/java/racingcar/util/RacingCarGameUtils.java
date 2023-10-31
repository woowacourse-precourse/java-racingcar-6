package racingcar.util;

import static racingcar.model.RacingCarGameConfig.RANDOM_MAXIMUM_VALUE;
import static racingcar.model.RacingCarGameConfig.RANDOM_MINIMUM_VALUE;

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
      throw new RacingCarGameException("라운드 횟수는 INT_MAXVALUE보다 클 수 없습니다.");
    }
    Integer input = Integer.parseInt(inputString);
    if (input < 0) {
      throw new RacingCarGameException("라운드 횟수는 0보다 작거나 같을 수 없습니다.");
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