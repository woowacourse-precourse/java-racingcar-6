package racingcar.util;

import java.util.Objects;
import racingcar.domain.Car;

public class InputValidator {
    private static final String INPUT_NON = "";

    public void nameNonInputValidate(int carsSize, String firstElementName) {
        if (carsSize == 1 && Objects.equals(firstElementName, INPUT_NON)) {
            printException("어떠한 이름도 입력되지 않았습니다! 값을 입력해주세요!");
        }
    }

    public void nameLengthValidate(Car car) {
        if (car.isNameLongerThenCriteria(5)) {
            printException("5자리 이하의 이름을 입력하시오!");
        }
    }

    public void roundNonInputValidate(String input) {
        if (Objects.equals(input, INPUT_NON)) {
            printException("어떠한 것도 입력되지 않았습니다! 값을 입력해주세요!");
        }
    }

    public void roundRegExValidate(String input) {
        if (!input.matches("^[0-9]*$")) {
            printException("입력에 숫자가 아닌 다른 문자가 포함되어 있습니다!");
        }
    }

    private void printException(String msg) {
        throw new IllegalArgumentException(msg);
    }
}
