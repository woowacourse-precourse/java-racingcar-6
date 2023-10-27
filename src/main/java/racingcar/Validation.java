package racingcar;

import java.util.List;

public class Validation {
    String carName;

    public boolean isLessThanSix(List<String> carNames) {
        for (int i = 0; i < carNames.size(); i++) {
            carName = carNames.get(i);
            if (carName.length() > 5) {
                return false;
            }
        }
        return true;
    }

    public boolean isNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("정수를 입력해주세요.");
        }
        return true;
    }
}
