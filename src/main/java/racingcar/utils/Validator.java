package racingcar.utils;

import java.util.List;
import racingcar.domain.RacingCar;

public class Validator {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;
    private static final String ERROR_TOO_BIG_SIZE = "이름의 길이는 5자 이하 여야하고, 빈칸이면 안됩니다.";
    private static final String ERROR_ONLY_INT = "숫자를 입력 해 주세요.";
    private static final String ERROR_LESS_THAN_ONE = "숫자는 양수여야 합니다.";

    public static void validate(List<RacingCar> racingCarList) {
        racingCarList.stream()
            .filter(car -> car.getName().length() > MAX_NAME_LENGTH || car.getName().isBlank())
            .findAny()
            .ifPresent(car -> {
                throw new IllegalArgumentException(ERROR_TOO_BIG_SIZE);
            });
    }

    public static int stringToInt(String str) {
        int number = parseToInt(str);
        validateNumber(number);
        return number;
    }

    private static int parseToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_ONLY_INT);
        }
    }

    private static void validateNumber(int number) {
        if (number < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_LESS_THAN_ONE);
        }
    }

}
