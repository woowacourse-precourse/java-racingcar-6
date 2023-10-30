package racingcar.game;

import racingcar.game.constant.CarExceptionMessage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringUtil {

    public static List<String> separate(String carNames) {
        String[] carNameArray = carNames.split(",");
        List<String> carNameList = Arrays.asList(carNameArray);
        validateNamesDifferent(carNameList);
        return carNameList;
    }

    private static void validateNamesDifferent(List<String> carNameList) {
        Set<String> uniqueNames = new HashSet<>();

        for (String carName : carNameList) {
            if (uniqueNames.contains(carName)) {
                throw new IllegalArgumentException(CarExceptionMessage.EXIST_SAME_NAMES);
            }
            uniqueNames.add(carName);
        }
    }

}
