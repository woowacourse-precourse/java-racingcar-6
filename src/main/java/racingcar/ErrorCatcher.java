package racingcar;

import java.util.List;

public class ErrorCatcher {
    private static final String CAR_NAMING_ERROR = "자동차의 이름은 5자 이하만 허용 합니다.";
    private static final String GAME_COUNT_ERROR = "시도할 횟수는 1회 이상만 허용 합니다.";
    public static void carNamingCheck(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) throw new IllegalArgumentException(CAR_NAMING_ERROR);
        }
    }
    public static void gameCountCheck(int gameCount) {
        if (gameCount < 1) throw new IllegalArgumentException(GAME_COUNT_ERROR);
    }
}
