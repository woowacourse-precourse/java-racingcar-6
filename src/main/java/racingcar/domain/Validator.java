package racingcar.domain;

import java.util.List;

public class Validator {
    public void validateCarNameLength(List<String> carNameList) {
        for (String carName : carNameList) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("유효하지 않은 값을 입력하여 게임을 종료하겠습니다.");
            }
        }
    }

    public void validateIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 값이 유효한 숫자가 아닙니다.", e);
        }
    }

    public static void valideteIsEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
    }
}
