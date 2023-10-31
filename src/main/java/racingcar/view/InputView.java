package racingcar.view;

import static racingcar.utils.Console.*;

import java.util.List;

public class InputView {
    private static final String INPUT_ATTEMPT_COUNT = "시도할 회수는 몇회인가요?";
    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String NOT_NUMERIC = "숫자를 입력해주세요";
    private static final String NAME_SEPARATOR = ",";
    private static final String INVALID_ATTEMPT_COUNT = "시도 횟수는 1 이상이어야 합니다";
    private static final int MIN_ATTEMPT_COUNT = 1;

    public int getAttemptCount() {
        println(INPUT_ATTEMPT_COUNT);

        int attemptCount = parseInt(readLine());
        validateAttemptCount(attemptCount);
        return attemptCount;
    }

    private void validateAttemptCount(int attemptCount) {
        if (attemptCount < MIN_ATTEMPT_COUNT) {
            throw new IllegalArgumentException(INVALID_ATTEMPT_COUNT);
        }
    }

    public List<String> getNames() {
        println(INPUT_CAR_NAMES);
        return List.of(readLine().split(NAME_SEPARATOR));
    }

    private int parseInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC);
        }
    }
}
