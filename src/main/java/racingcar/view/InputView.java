package racingcar.view;

import static racingcar.utils.Console.println;
import static racingcar.utils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import racingcar.enums.ErrorMessage;
import racingcar.enums.GameCondition;
import racingcar.enums.RegexPattern;
import racingcar.enums.Symbols;

public class InputView {
    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 %s(%s) 기준으로 구분)";
    private static final String INPUT_GAME_COUNT = "시도할 횟수는 몇회인가요?";
    private static final String POSITIVE_INTEGER_REGEX = RegexPattern.CAR_COUNT.getPattern();
    private String message = "";

    public List<String> readCarNames() {
        String symbolName = String.valueOf(Symbols.COMMA);
        String delimiter = Symbols.COMMA.getSymbol();

        if (delimiter.equals(",")) {
            symbolName = "쉼표";
        }

        println(String.format(INPUT_CAR_NAME, symbolName, delimiter));
        String input = readLine();
        validateNotNull(input);

        return Arrays.stream(input.split(Symbols.COMMA.getSymbol()))
                .toList();
    }

    public int readCount() {
        println(INPUT_GAME_COUNT);
        return parseInt(readLine());
    }

    private void validateNotNull(String input) {
        message = ErrorMessage.INPUT_IS_NULL.getMessage();
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    private int parseInt(String count) {
        validateNumberInput(count);
        int parsedCount;
        message = String.format(ErrorMessage.INVALID_CAR_NAME.getMessage(), GameCondition.MIN_COUNT);
        try {
            parsedCount = Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(message);
        }
        return parsedCount;
    }

    private void validateNumberInput(String count) {
        message = String.format(ErrorMessage.INVALID_COUNT.getMessage(), GameCondition.MIN_COUNT.getValue());
        if (!count.matches(POSITIVE_INTEGER_REGEX)) {
            throw new IllegalArgumentException(message);
        }
    }
}
