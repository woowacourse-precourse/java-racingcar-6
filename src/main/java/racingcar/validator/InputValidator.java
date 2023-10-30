package racingcar.validator;

import java.util.Arrays;

public class InputValidator {

    private final String CAR_NAME_REGEX = "\\w+(\\s+\\w+)*(,\\w+(\\s+\\w+)*)*"; // ,뒤 공백은 비허용/이름 사이 공백은 허용
    private final String TRY_COUNT_REGEX = "[1-9]\\d*";

    public void validateInputCarName(String carName) {
        String[] names = carName.split(",");

        checkValidatedCarName(carName);
        checkDuplicateCarName(names);
        checkParticipantSizeUnderTwo(names);
        checkNameLengthOverFive(names);
    }

    private void checkValidatedCarName(String carName) {
        if (!carName.matches(CAR_NAME_REGEX)) {
            throw new IllegalArgumentException();
        }
    }

    public void validateInputTryCount(String tryCount) {
        if (!tryCount.matches(TRY_COUNT_REGEX)) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicateCarName(String[] names) {
        long nonDuplicatedNameSize = Arrays.stream(names)
                .distinct()
                .count();

        if (nonDuplicatedNameSize != names.length) {
            throw new IllegalArgumentException();
        }
    }

    private void checkParticipantSizeUnderTwo(String[] names) {
        if (names.length < 2) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNameLengthOverFive(String[] names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }
}
