package racingcar.game;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static racingcar.game.constant.CarExceptionMessage.EXIST_SAME_NAMES;
import static racingcar.game.constant.CarExceptionMessage.OUT_OF_COUNT_RANGE;

public class StringUtil {

    public static List<String> separate(String carNames) {
        String[] carNameArray = carNames.split(",");
        List<String> carNameList = Arrays.asList(carNameArray);
        validateNamesDifferent(carNameList);
        validateNamesCount(carNameList);
        return carNameList;
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

}
