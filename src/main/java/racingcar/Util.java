package racingcar;

import java.util.List;

public class Util {
    public static void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하로 이루어져야 합니다!");
        }
    }

    public static void checkForDuplicates(List<String> array) {
        if (array.size() != array.stream().distinct().count()) {
            throw new IllegalArgumentException("자동차 이름에 중복이 있어서는 안됩니다!");
        }
    }
}
