package racingcar;

import java.util.Arrays;
import java.util.List;

public class UserInput {
    public List<String> getCarNames(String carNames) {
        return Arrays.asList(carNames.split(","));
    }

    public int getAttemptsNumber(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 숫자만 가능합니다.");
        }
    }
}
