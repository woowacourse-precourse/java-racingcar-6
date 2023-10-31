package racingcar.validate;

import java.util.List;

public class Validator {

    public static void inputNameSize(List<String> inputName) {
        for (String car : inputName) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야합니다.");
            }
        }
    }
}
