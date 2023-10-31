package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Input {

    public static List<Car> inputCarNames(String input) {
        return null;
    }

    public static int inputTryCount(String input) {
        try {
            return Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 input 형식입니다.");
        }
    }
}
