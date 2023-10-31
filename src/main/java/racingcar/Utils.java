package racingcar;

import static racingcar.constant.MessageConstants.DASH;
import static racingcar.constant.MessageConstants.NONE_INSTANTIABLE_CLASS;
import static racingcar.constant.MessageConstants.PARSE_CAR_NAME_DELIMITER;
import static racingcar.constant.NumberConstants.MAX_MOVE_CONDITION;
import static racingcar.constant.NumberConstants.MIN_MOVE_CONDITION;
import static racingcar.constant.NumberConstants.ZERO;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Utils {

    private Utils() {
        throw new AssertionError(NONE_INSTANTIABLE_CLASS);
    }

    public static List<String> parseCarName(String input) {
        return List.of(input.split(PARSE_CAR_NAME_DELIMITER));
    }

    public static int makeRandomNumber() {
        return Randoms.pickNumberInRange(MIN_MOVE_CONDITION, MAX_MOVE_CONDITION);
    }

    public static String repeatDash(int position) {
        return DASH.repeat(Math.max(ZERO, position));
    }

}
