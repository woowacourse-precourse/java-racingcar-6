package racingcar.validator;

import static racingcar.Config.MAXIMUM_CAR_NAME;

import java.util.List;
import racingcar.model.Car;

public class InputValidator {

    // 11. 자동차 이름이 5글자 이하인지, 공백 문자열이 아닌지 검사하는 메서드
    public static void validateCarNameLength(List<Car> carNames) {
        for(Car car: carNames) {
            if (car.getName().length() > MAXIMUM_CAR_NAME) {
                throw new IllegalArgumentException("자동차의 이름은 5글자 이하여야 합니다.");
            } else if (car.getName().equals("")) {
                throw new IllegalArgumentException("자동차의 이름은 최소 한 글자 입니다.");
            }
        }
    }

    // 12. 시도할 횟수를 입력할 때 입력한 값이 숫자로만 이루어져 있는지 검사하는 메서드
    public static void validateTrialNumber(String inputNum) {
        for(int index=0; index<inputNum.length(); index++) {
            if (isInputNotDigit(inputNum, index)) {
                throw new IllegalArgumentException("시도할 횟수는 숫자만 입력해야 합니다.");
            }
        }
    }

    private static boolean isInputNotDigit(String inputNum, int index) {
        return !Character.isDigit(inputNum.charAt(index));
    }

}
