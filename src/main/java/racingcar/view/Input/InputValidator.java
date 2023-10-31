package racingcar.view.Input;

import java.util.List;
import racingcar.domain.Car;

public class InputValidator {
    private final String NUMBER_REGX = "^[0-9]+$";
    private final String CAR_REGEX = "^[a-zA-Z가-힣]+$";

        // [x] 쉼표가 연속해서 있을 경우 >> 정규 표현식 split(",+")
        // [x] 쉼표 사이에 공백이 있을 경우 >> replace(" ", "");
        // [x] 공백일 경우 >> exception
    public void validateIsString(List<String> inputCars) {
        boolean isValid = inputCars.stream().noneMatch(input -> input.matches(CAR_REGEX));

        if (isValid) {
            throw new IllegalArgumentException("문자만 입력 가능합니다.");
        }

    }

    public void validateCarString(String input) {
        if (input.trim() == null) {
            throw new IllegalArgumentException("");
        }
    }

    public void isNumberOnly(String number) {
        if (!number.matches(NUMBER_REGX)) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }
    public void isPositiveOnly(String number) {
        if (Integer.parseInt(number) < 0) {
            throw new IllegalArgumentException("1회 부터 입력 가능 합니다.");
        }
    }
}
