package racingcar.view;

import java.util.Arrays;
import java.util.List;

public class Mapper {
    public static List<String> changeToListString(String carName) {
        return Arrays.stream(carName.split(","))
                .toList();
    }

    public static int changeToInteger(String number) {
        if (number.length() >= 10) {
            throw new IllegalArgumentException("너무 큰 숫자를 입력했습니다.");
        }

        int moveNumber;
        try {
            moveNumber = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야합니다.");
        }
        return moveNumber;
    }
}
