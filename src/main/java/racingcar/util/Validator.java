package racingcar.util;


import static racingcar.util.Validator.ErrorMessage.INVALID_FORMAT_EXCEPTION;
import static racingcar.util.Validator.ErrorMessage.INVALID_LENGTH_EXCEPTION;
import static racingcar.util.Validator.ErrorMessage.INVALID_LOCATION;
import static racingcar.util.Validator.ErrorMessage.INVALID_RACE_COUNT;
import static racingcar.util.Validator.ErrorMessage.NOT_EXIST_EXCEPTION;
import static racingcar.util.Validator.ErrorMessage.START_ZERO_EXCEPTION;

import java.util.Arrays;

public class Validator {
    private static final String REGEX_RACE_COUNT = "([1-9])+[0-9]*";
    private static final String REGEX_NAMES_FORMAT = "([\\w가-힣]{1,5},?)+";
    private static final String COMMA = ",";
    private static final String ZERO_STRING = "0";
    private static final int ZERO_INT = 0;
    private static final int MAX_NAME_LENGTH = 5;

    public void validateCarName(String name) {
        if (name.isBlank() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_LENGTH_EXCEPTION.getMessage());
        }
    }

    public void validateCarLoccation(int location) {
        if (location < ZERO_INT) {
            throw new IllegalArgumentException(INVALID_LOCATION.getMessage());
        }
    }

    public void validateRaceCount(String raceCount) {
        if (raceCount == null || raceCount.isBlank()) {
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
        return raceCount.startsWith(ZERO_STRING);
    }

    private boolean isInvalidRaceCountFormat(String raceCount) {
        return !raceCount.matches(REGEX_RACE_COUNT);
    }

    public void validateNames(String names) {
        if (names.isBlank()) {
            throw new IllegalArgumentException(NOT_EXIST_EXCEPTION.getMessage());
        }
        if (isInvalidNamesFormat(names)) {
            throw new IllegalArgumentException(INVALID_FORMAT_EXCEPTION.getMessage());
        }
        if (hasInvalidLength(names)) {
            throw new IllegalArgumentException(INVALID_LENGTH_EXCEPTION.getMessage());
        }
    }

    private boolean hasInvalidLength(String names) {
        return Arrays.stream(names.split(COMMA))
                .anyMatch(name -> name.isEmpty() || name.length() > MAX_NAME_LENGTH);
    }

    private boolean isInvalidNamesFormat(String names) {
        // 입력의 형태가 조건의 형식대로 이루어졌는지 확인
        return !names.matches(REGEX_NAMES_FORMAT);
    }

    enum ErrorMessage {
        NOT_EXIST_EXCEPTION("입력값이 존재하지 않습니다."),
        INVALID_LENGTH_EXCEPTION("이름은 1글자부터 5글자까지 가능합니다."),
        INVALID_FORMAT_EXCEPTION("입력 형식이 올바르지 않습니다."),
        START_ZERO_EXCEPTION("0으로 시작할 수 없습니다."),
        INVALID_RACE_COUNT("경주 횟수는 1 이상의 정수값만 가능합니다."),
        INVALID_LOCATION("위치값은 음수일 수 없습니다.");

        private final String message;

        ErrorMessage(String message) {
            this.message = message;
        }

        private String getMessage() {
            return message;
        }
    }
}
