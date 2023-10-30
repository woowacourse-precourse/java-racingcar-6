package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.util.Constants;

public class InputView {
    private final static String SEPARATOR = ",";
    private final static String INVALID_SEPARATOR_MESSAGE = "자동차를 구분하는 기준은 쉼표(,)여야 합니다.";
    private final static String INVALID_NAME_COUNT_MESSAGE = "자동차 이름은 2개 이상이어야 합니다.";
    public static List<String> inputNames() {
        OutputView.printNameInputMessage();

        String input = Console.readLine();

        validateInputWithSeparator(input);

        List<String> names = splitToStringList(input);

        validateInputCount(names);

        return names;
    }
    private static void validateInputWithSeparator(String input) {
        if (!input.contains(SEPARATOR)) {
            throw new IllegalArgumentException(INVALID_SEPARATOR_MESSAGE);
        }
    }

    private static void validateInputCount(List<String> names) {
        if (names.size() < Constants.MIN_INPUT_COUNT) {
            throw new IllegalArgumentException(INVALID_NAME_COUNT_MESSAGE);
        }
    }

    public static String inputRound() {
        OutputView.printRoundInputMessage();
        return Console.readLine();
    }

    private static List<String> splitToStringList(String name) {
        return Arrays
                .stream(name.split(SEPARATOR))
                .toList();
    }
}
