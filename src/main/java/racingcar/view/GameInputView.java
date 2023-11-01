package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

import static racingcar.error.ErrorType.INVALID_CAR_NAME_LENGTH;

public class GameInputView {

    public static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private static final String CAR_NAME_DELIMITER = ",";

    public static List<String> inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        String[] carNames = Console.readLine().split(CAR_NAME_DELIMITER);
        validateAllStringsFiveOrLess(carNames);
        return Arrays
                .stream(carNames)
                .toList();
    }

    private static void validateAllStringsFiveOrLess(String... strings) {
        boolean existsOverFive = Arrays
                .stream(strings)
                .anyMatch(s -> s.length() > 5);
        if (existsOverFive) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH.getMessage());
        }
    }
}
