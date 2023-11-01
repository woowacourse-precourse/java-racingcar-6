package racingcar.view;

import java.util.function.Supplier;

public class InputView {
    private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_COUNT_INPUT_MESSAGE = "시도할 회수는 몇 회인가요?";
    private static final String BLANK_EXCEPTION_MESSAGE = "Error: 입력은 공백이거나 비어있을 수 없습니다.";
    private static final String ATTEMPT_COUNT_NUMBER_EXCEPTION_MESSAGE = "Error: 시도 횟수는 숫자여야 합니다.";
    private static final String CAR_NAMES_DELIMITER = ",";

    private final Supplier<String> reader;

    public InputView(Supplier<String> reader) {
        this.reader = reader;
    }

    public String[] readCarNames() {
        System.out.println(CAR_NAMES_INPUT_MESSAGE);
        String carNames = reader.get();

        validateIsBlank(carNames);

        return carNames.split(CAR_NAMES_DELIMITER);
    }

    private void validateIsBlank(String string) {
        if (string.isBlank()) {
            throw new IllegalArgumentException(BLANK_EXCEPTION_MESSAGE);
        }
    }

    public int readAttemptCount() {
        System.out.println(ATTEMPT_COUNT_INPUT_MESSAGE);
        String attemptCount = reader.get();

        validateAttemptCount(attemptCount);

        return Integer.parseInt(attemptCount);
    }

    private void validateAttemptCount(String attemptCount) {
        validateIsBlank(attemptCount);
        validateIsNumber(attemptCount);
    }

    private void validateIsNumber(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ATTEMPT_COUNT_NUMBER_EXCEPTION_MESSAGE);
        }
    }
}
