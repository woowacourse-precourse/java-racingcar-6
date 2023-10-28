package racingcar.view;

import java.util.List;

public class InputVerification {

    public boolean verifyCarNamesInput(List<String> cars) {
        for (String car : cars) {
            if (car.length() == 0 || car.length() > 5) {
                throw new IllegalArgumentException("옳지 않은 입력 길이입니다.");
            }
        }
        return true;
    }
}
