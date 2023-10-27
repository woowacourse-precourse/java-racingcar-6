package racingcar.game.validate;

import java.util.List;

public class EmptyCarNamesValidator {

    private static final String EMPTY_CAR_NAMES = "자동차 이름 목록이 비어있습니다.";

    public static void validate(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_CAR_NAMES);
        }
    }
}
