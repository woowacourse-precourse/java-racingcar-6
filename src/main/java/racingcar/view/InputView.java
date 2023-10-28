package racingcar.view;

import static racingcar.utils.Console.println;
import static racingcar.utils.Console.readLine;

public class InputView {
    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분";
    private static final String INPUT_GAME_COUNT = "시도할 회수는 몇회인가요?";
    private static final String INPUT_IS_NOT_NUMBER = "입력 값은 1 이상의 숫자여야 합니다.";
    private static final String INPUT_IS_NULL = "아무런 값도 입력하지 않으셨습니다.";
    private static final String POSITIVE_INTEGER_REGEX = "^[1-9]\\d*$";


    public String readCarNames() {
        println(INPUT_CAR_NAME);
        String input = readLine();
        validateNotNull(input);
        return input;
    }

    public int readCount() {
        println(INPUT_GAME_COUNT);
        return readInt();
    }

    private int readInt() {
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
        if (!count.matches(POSITIVE_INTEGER_REGEX)) {
            throw new IllegalArgumentException(INPUT_IS_NOT_NUMBER);
        }
    }
}
