package racingcar.util;

import java.util.List;

public class Validator {
    public static void checkCarNameListSize(List<String> carNameList) {
        final int CAR_NAME_SIZE_MIN = 1;
        if (carNameList.isEmpty() || (carNameList.size() == CAR_NAME_SIZE_MIN)) {
            throw new IllegalArgumentException(Constants.CAR_LIST_SIZE_ERROR);
        }
    }

    public static void checkCarNameEmpty(List<String> carNameList) {
        for (String carName : carNameList) {
            if (carName.trim() == "") {
                throw new IllegalArgumentException(Constants.EMPTY_CAR_NAME_ERROR);
            }
        }
    }

    public static void checkCarNameLength(List<String> carNameList) {

        final int NAME_LENGTH_MAX = 5;

        for (String carName : carNameList) {

            if (carName.length() > NAME_LENGTH_MAX) {
                throw new IllegalArgumentException(
                        String.format("%s [입력 값 : %s]", Constants.OVER_LENGTH_CAR_NAME_ERROR, carName));
            }
        }
    }

    public static void containsOnlyNumbers(String string) {
        System.out.println(string);
        if (!string.matches(Constants.MOVE_TRY_COUNT_REGEX)) {
            throw new IllegalArgumentException(Constants.INPUT_MOVE_TRY_CONTAIN_STRING);
        }
    }
}
