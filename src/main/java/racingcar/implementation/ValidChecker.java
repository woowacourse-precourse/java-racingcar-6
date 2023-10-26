package racingcar.implementation;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ValidChecker {

    public static List<String> carListCheck(String input) {
        List<String> carList = Arrays.stream(input.split(",")).toList();
        Iterator<String> iterator = carList.iterator();

        while (iterator.hasNext()) {
            String car = iterator.next();
            if (car.length() > 5) {
                throw new IllegalArgumentException("자동차의 이름은 다섯 글자 이하만 가능합니다.");
            }
        }
        return carList;
    }

    public static int numberOfTryCheck(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("숫자를 입력하세요.");
        }
    }
}
