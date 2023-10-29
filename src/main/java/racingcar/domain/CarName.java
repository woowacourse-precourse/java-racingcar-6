package racingcar.domain;

import racingcar.common.exception.CustomErrorException;

import java.util.Objects;

import static racingcar.common.response.ErrorCode.*;

public record CarName(String name) {

    private static final int MIN_NAME_SIZE = 1;
    private static final int MAX_NAME_SIZE = 5;
    private static final String SPACE = " ";

    public CarName {
        validateName(name);
    }

    private static void validateName(String name) {
        if (isNull(name)) {
            throw new CustomErrorException(CAR_NAME_NULL);
        }

        if (isInvalidLength(name)) {
            throw new CustomErrorException(CAR_NAME_INVALID_LENGTH);
        }

        if (isContainSpace(name)) {
            throw new CustomErrorException(CAR_NAME_CONTAIN_SPACE);
        }
    }

    private static boolean isNull(String name) {
        return Objects.isNull(name);
    }

    private static boolean isInvalidLength(String name) {
        return name.length() < MIN_NAME_SIZE || name.length() > MAX_NAME_SIZE;
    }

    private static boolean isContainSpace(String name) {
        return name.contains(SPACE);
    }
}
