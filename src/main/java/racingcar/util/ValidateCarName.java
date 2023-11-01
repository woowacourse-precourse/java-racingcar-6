package racingcar.util;

import java.util.List;

public class ValidateCarName {

    private static List<String> splitCarName(String InputCarName) {

        List<String> carNameList;

        try {
            carNameList = List.of(InputCarName.split(","));
        }
        catch (NullPointerException e) {
            throw new IllegalArgumentException("자동차 이름은 쉼표(,)로 구분되어야 합니다.");
        }

        return carNameList;
    }

    private static void IsUnderFive(String carName) {

        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }

    }

}
