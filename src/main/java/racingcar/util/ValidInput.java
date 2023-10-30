package racingcar.util;

import static racingcar.constant.NumberConst.MAX_CAR_NAME_LENGTH;

import java.util.Arrays;
import java.util.List;

public class ValidInput {

    public static void validCarNameLength(String carNames) {
        List<String> carNameList = Arrays.stream(carNames.split(",")).toList();
        for (String carName : carNameList) {
            if (carName.length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validDistinctCarName(String carNames) {
        List<String> carNameList = Arrays.stream(carNames.split(",")).toList();
        if (carNameList.stream().distinct().count() != carNameList.stream().count()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validOnlyNumber(String input) {
        String reg = "^[0-9]*$";
        if (!input.matches(reg)) {
            throw new IllegalArgumentException();
        }
    }
}
