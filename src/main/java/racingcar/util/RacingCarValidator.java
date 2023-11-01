package racingcar.util;

import java.util.List;

public class RacingCarValidator {
    public String carNameLength(List<String> joinCarsName) {
        if (joinCarsName.size() <= 1) inputException();

        for (String joinCarName : joinCarsName) {
            if (joinCarName.length() > 5 || joinCarName.length() == 0) inputException();
        }
        return "ok";
    }

    public int number(String GameCount) {
        if (!GameCount.matches("^[1-9]\\d*$")) { // 자연수 정규식
            inputException();
        }
        return Integer.parseInt(GameCount);
    }


    public static void inputException() {
        throw new IllegalArgumentException();
    }
}

