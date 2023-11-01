package racingcar;

import java.util.List;
import racingcar.constants.Constants;

public class Validator {

    public static void validateNumber(String number) throws IllegalArgumentException {
        if (!Constants.gameCountPattern.matcher(number).matches()) {
            throw new IllegalArgumentException("정수를 입력해 주세요");
        }
    }

    public static void validateString(List<String> carNames) throws IllegalArgumentException {
        for (String carName : carNames) {
            if (!Constants.nameStringPattern.matcher(carName).matches() || carName.length() > 5) {
                throw new IllegalArgumentException("5글자 이하로 공백 없이 입력해 주세요.");
            }
        }
    }
}
