package racingcar.validator;

import static racingcar.common.Constants.MAXIMUM_CAR_NAME_LENGTH;
import static racingcar.common.Constants.MINIMUM_PARTICIPANTS_NUMBER;

import java.util.List;
import racingcar.util.StringUtil;

public class InputValidator {
    public static void validateCarList(List<String> carList) {
        checkMinimumParticipantsNumber(carList);
        checkLengthCondition(carList);
    }

    private static void checkLengthCondition(List<String> carList) {
        for (String car : carList) {
            StringUtil.checkMaxLengthLimit(car, MAXIMUM_CAR_NAME_LENGTH);
        }
    }

    private static void checkMinimumParticipantsNumber(List<String> carList) {
        if (carList.size() < MINIMUM_PARTICIPANTS_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public static void validatePlayCount(Integer playCount) {
        if (playCount < 1) {
            throw new IllegalArgumentException();
        }
    }
}
