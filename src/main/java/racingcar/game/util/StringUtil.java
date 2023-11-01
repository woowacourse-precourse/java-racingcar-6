package racingcar.game.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static racingcar.game.constant.CarExceptionMessage.EXIST_SAME_NAMES;
import static racingcar.game.constant.CarExceptionMessage.OUT_OF_COUNT_RANGE;
import static racingcar.game.constant.RoundExceptionMessage.NOT_INTEGER;

public class StringUtil {

    public static List<String> separate(String carNames) {
        String[] carNameArray = carNames.split(",");
        List<String> carNameList = Arrays.asList(carNameArray);

        validateNamesDifferent(carNameList);
        validateNamesCount(carNameList);

        return carNameList;
    }

    public static int makeInteger(String stringMovingCount) {
        int movingCount = validateInteger(stringMovingCount);

        return movingCount;
    }

    private static void validateNamesDifferent(List<String> carNameList) throws IllegalArgumentException {
        Set<String> uniqueNames = new HashSet<>();

        for (String carName : carNameList) {
            if (uniqueNames.contains(carName)) {
                throw new IllegalArgumentException(EXIST_SAME_NAMES);
            }
            uniqueNames.add(carName);
        }
    }

    private static void validateNamesCount(List<String> carNameList) {
        if (carNameList.size() > 10) {
            throw new IllegalArgumentException(OUT_OF_COUNT_RANGE);
        }
    }

    private static int validateInteger(String stringMovingCount) {
        try {
            return Integer.parseInt(stringMovingCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER, e);
        }
    }

}
