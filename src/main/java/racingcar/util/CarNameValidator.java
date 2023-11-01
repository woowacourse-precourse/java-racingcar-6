package racingcar.util;

import java.util.ArrayList;
import java.util.List;

public class CarNameValidator {
    private final static int MAX_CARNAME = 5;

    public static List<String> validateCarNameInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 없습니다");
        }
        if (input.split(",").length != input.chars().filter(c -> c == ',').count() + 1) {
            throw new IllegalArgumentException("입력 값의 형식이 잘못되었습니다");
        }
        String[] carNames = input.split(",");
        List<String> validateCarNames = new ArrayList<>();

        for (String name : carNames) {
            if (name.length() > MAX_CARNAME) {
                throw new IllegalArgumentException(String.format("자동차 이름이 %s글자 이하이어야 합니다", MAX_CARNAME));
            }
            validateCarNames.add(name);
        }
        return validateCarNames;

    }
}
