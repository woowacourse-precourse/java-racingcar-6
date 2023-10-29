package racingcar;

import java.util.Objects;

public class InputValidator {
    public void nameNonInputValidate(int carsSize, String firstElementName) {
        if (carsSize == 1 && Objects.equals(firstElementName, "")) {
            throw new IllegalArgumentException("어떠한 이름도 입력되지 않았습니다!");
        }
    }

    public void nameLengthValidate(Car car) {
        if (car.isNameLongerThenCriteria(5)) {
            throw new IllegalArgumentException("5자리 이하의 이름을 입력하시오!");
        }
    }

    public void roundNonInputValidate(String input) {
        if (Objects.equals(input, "")) {
            throw new IllegalArgumentException("어떠한 것도 입력되지 않았습니다! 값을 입력해주세요!");
        }
    }

    public void roundRegExValidate(String input) {
        if (!input.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("입력에 숫자가 아닌 다른 문자가 포함되어 있습니다!");
        }
    }
}
