package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.validator.Validator;

public class InputView {
    private static final String READ_RACING_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String READ_TRY_COUNT = "시도할 회수는 몇회인가요?";
    private static final String SEPARATOR = ",";

    public static List<String> readRacingCarName() {
        System.out.println(READ_RACING_CAR_NAME);
        String racingCarName = Console.readLine();
        return splitStringBySeparator(racingCarName);
    }

    private static List<String> splitStringBySeparator(String input) {
        return Arrays.stream(input.split(SEPARATOR))
                .map(String::trim)
                .toList();
    }

    public static long readTryCount() {
        System.out.println(READ_TRY_COUNT);
        String tryCount = Console.readLine().trim();
        validateTryCount(tryCount);

        return Long.parseLong(tryCount);
    }

    private static void validateTryCount(String tryCount) {
        Validator.validateIsBlank(tryCount);
        Validator.validateIsNumeric(tryCount);
    }
}