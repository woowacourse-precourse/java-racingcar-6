package racingcar;

import static racingcar.InputProvider.ErrorMessage.INVALID_FORMAT_EXCEPTION;
import static racingcar.InputProvider.ErrorMessage.INVALID_LENGTH_EXCEPTION;
import static racingcar.InputProvider.ErrorMessage.INVALID_RACE_COUNT;
import static racingcar.InputProvider.ErrorMessage.NOT_EXIST_EXCEPTION;
import static racingcar.InputProvider.ErrorMessage.START_ZERO_EXCEPTION;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public final class InputProvider {
    private static final String RACE_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String COMMA = ",";
    private static final String ZERO = "0";
    private static final int MAX_NAME_LENGTH = 5;
    private static final InputProvider inputProvider = new InputProvider();

    private InputProvider() {
    }

    public static InputProvider getInstance() {
        return inputProvider;
    }

    public int receiveRaceCount() {
        System.out.println(RACE_COUNT_INPUT_MESSAGE);
        String raceCount = Console.readLine();
        validateRaceCount(raceCount);

        return Integer.parseInt(raceCount);
    }

    public String receiveCarNames() {
        System.out.println(CAR_NAMES_INPUT_MESSAGE);
        String names = Console.readLine();
        validateNames(names);

        return names;
    }

    private void validateRaceCount(String raceCount) {
        if (raceCount.isEmpty()) {
            throw new IllegalArgumentException(NOT_EXIST_EXCEPTION.getMessage());
        }
        if (isRaceCountStartsZero(raceCount)) {
            throw new IllegalArgumentException(START_ZERO_EXCEPTION.getMessage());
        }
        if (isInvalidRaceCountFormat(raceCount)) {
            throw new IllegalArgumentException(INVALID_RACE_COUNT.getMessage());
        }
    }

    private boolean isRaceCountStartsZero(String raceCount) {
        return raceCount.startsWith(ZERO);
    }

    private boolean isInvalidRaceCountFormat(String raceCount) {
        return !raceCount.matches("[0-9]+");
    }

    private void validateNames(String names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException(NOT_EXIST_EXCEPTION.getMessage());
        }
        if (hasInvalidLength(names)) {
            throw new IllegalArgumentException(INVALID_LENGTH_EXCEPTION.getMessage());
        }
        if (isInvalidNamesFormat(names)) {
            throw new IllegalArgumentException(INVALID_FORMAT_EXCEPTION.getMessage());
        }
    }

    private boolean hasInvalidLength(String names) {
        return Arrays.stream(names.split(COMMA))
                .anyMatch(name -> name.isEmpty() || name.length() > MAX_NAME_LENGTH);
    }

    private boolean isInvalidNamesFormat(String names) {
        // 입력의 형태가 조근의 형식대로 이루어졌는지 확인
        return !names.matches("([\\w가-힣]{1,5},?)+");
    }

    enum ErrorMessage {
        NOT_EXIST_EXCEPTION("입력값이 존재하지 않습니다."),
        INVALID_LENGTH_EXCEPTION("이름은 1글자부터 5글자까지 가능합니다."),
        INVALID_FORMAT_EXCEPTION("입력 형식이 올바르지 않습니다."),
        START_ZERO_EXCEPTION("0으로 시작할 수 없습니다."),
        INVALID_RACE_COUNT("경주 횟수는 1 이상의 정수값만 가능합니다.");

        private final String message;

        ErrorMessage(String message) {
            this.message = message;
        }

        private String getMessage() {
            return message;
        }
    }
}
