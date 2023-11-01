package baseball.utils;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;

public class InputValidator {
    private final String USER_INPUT_REGEX = "[1-9]+";

    public void checkCarLength(List<Car> carsList) {
        for (Car car : carsList) {
            if (car.getName().length() >= 6) {
                throw new IllegalArgumentException("입력 가능한 자동차의 이름은 5자 이하입니다.");
            }
        }
    }

    // "우승자는 한 명 이상일 수 있다." -> 1대 이상의 자동차 이름 입력 필요
    public void checkLength(List<Car> carsList) {
        if (carsList.isEmpty()) {
            throw new IllegalArgumentException("1대 이상의 자동차 이름을 입력해주세요.");
        }
    }

    public void checkDigit(String userInput) {
        if (!userInput.matches(USER_INPUT_REGEX)) {
            throw new IllegalArgumentException("시도 회수는 숫자여야합니다.");
        }
    }
}
