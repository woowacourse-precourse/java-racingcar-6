package racingcar.validation;


import java.lang.invoke.StringConcatFactory;
import racingcar.User;

public class Validator {

    public void checkCarNameCount(String[] carNames) {
        if (carNames.length <= 1) {
            throw new IllegalArgumentException("경주할 수 있는 최소 자동차는 2대 이상 입니다.");
        }
    }
    public void checkCarNameLength(String[] carNames) {
        for (String carName : carNames) {
            carNameMaxLength(carName);
        }
    }

    private static void carNameMaxLength(String carName) {
        if (carName.trim().length() > 5) {
            throw new IllegalArgumentException("자동차 이름의 글자 길이는 5글자 이하 입니다.");
        }
    }
}
