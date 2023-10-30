package racingcar.view;

import static racingcar.utils.Console.println;
import static racingcar.utils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import racingcar.enums.GameCondition;
import racingcar.enums.RegexPattern;
import racingcar.enums.Symbols;

public class InputView {
    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 %s(%s) 기준으로 구분)";
    private static final String INPUT_GAME_COUNT = "시도할 횟수는 몇회인가요?";
    private static final String INPUT_IS_NOT_NUMBER = "입력 값은 %d 이상의 숫자여야 합니다.";
    private static final String INPUT_IS_NULL = "아무런 값도 입력하지 않으셨습니다.";
    private static final String POSITIVE_INTEGER_REGEX = RegexPattern.CAR_COUNT.getPattern();

    public List<String> readCarNames() {
        println(String.format(INPUT_CAR_NAME, Symbols.쉼표,Symbols.쉼표.getSymbol()));
        String input = readLine();
        validateNotNull(input);
        return Arrays.stream(input.split(Symbols.쉼표.getSymbol()))
                .map(String::trim)
                .toList();
    }

    public int readCount() {
        println(INPUT_GAME_COUNT);
        return parseInt(readLine());
    }

    private int parseInt(String count) {
        validateNumberInput(count);
        int parsedCount;
        try {
            parsedCount = Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_IS_NOT_NUMBER);
        }
        return parsedCount;
    }

    private static void validateNotNull(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(INPUT_IS_NULL);
        }
    }

    private static void validateNumberInput(String count) {
        int minCount = GameCondition.MIN_COUNT.getValue();

        if (!count.matches(POSITIVE_INTEGER_REGEX)) {
            throw new IllegalArgumentException(String.format(INPUT_IS_NOT_NUMBER, minCount));
        }
    }
}
