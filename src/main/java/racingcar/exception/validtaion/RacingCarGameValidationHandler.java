package racingcar.exception.validtaion;

import java.util.List;
import racingcar.domain.entity.Car;

public class RacingCarGameValidationHandler {

    public static final String PROMPT_GAME_COUNT_INPUT = "시도할 게임 횟수를 입력해주세요.";
    public static final String GAME_COUNT_FORMAT_RESTRICTION = "시도할 게임 횟수는 숫자로 입력해주세요.";
    public static final String MAX_GAME_COUNT_RESTRICTION = "시도할 게임 횟수는 100회 이하로 입력해주세요.";
    public static final String CARS_IS_EMPTY = "자동차 경주에 필요한 자동차가 없습니다.";

    private RacingCarGameValidationHandler() {
    }

    public static void validationCarsEmpty(List<Car> cars) {
        if (isCarsEmpty(cars)) {
            throw new IllegalArgumentException(CARS_IS_EMPTY);
        }
    }

    public static void validationHasText(String gamCount) {
        if (!hasText(gamCount)) {
            throw new IllegalArgumentException(PROMPT_GAME_COUNT_INPUT);
        }
    }

    public static void validationNumeric(String gameCount) {
        if (!isNumeric(gameCount)) {
            throw new IllegalArgumentException(GAME_COUNT_FORMAT_RESTRICTION);
        }
    }

    public static void validationUnderOrEqual100(String gameCount) {
        if (!isUnderOrEqual100(gameCount)) {
            throw new IllegalArgumentException(MAX_GAME_COUNT_RESTRICTION);
        }
    }

    private static boolean isUnderOrEqual100(String gameCount) {
        return Integer.parseInt(gameCount) <= 100;
    }

    private static boolean isNumeric(String gameCount) {
        return gameCount.chars()
                .allMatch(Character::isDigit);
    }

    private static boolean hasText(String gameCount) {
        return gameCount != null && !gameCount.isEmpty() && containsText(gameCount);
    }

    private static boolean containsText(String gameCount) {
        for (char ch : gameCount.toCharArray()) {
            if (!Character.isWhitespace(ch)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isCarsEmpty(List<Car> cars) {
        return cars.isEmpty();
    }
}
