package racingcar.domain;

import java.util.List;

public class UserInputParser {
    public int parseInt(String userInput) {
        int result = 0;

        try {
            result = Integer.parseInt(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }

        return result;
    }

    public List<Car> generateCarList(String userInput) {
        return null;
    }
}
