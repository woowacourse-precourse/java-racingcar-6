package racingcar.util;

import java.util.List;

public class Validator {
    public void car(List<String> carList) throws IllegalArgumentException {
        for (String s : carList) {
            if (s.length() > 5) {
                throw new IllegalArgumentException("유효하지 않은 입력값입니다. 자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public void lap() {

    }
}
