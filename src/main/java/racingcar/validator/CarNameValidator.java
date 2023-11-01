package racingcar.validator;

import racingcar.exception.ExceptionMessage;

import java.util.List;

public class CarNameValidator {
    private static final int NAME_LIMIT_LENGTH = 5;

    private CarNameValidator() {
        throw new AssertionError();
    }

    public static void validateWhiteSpace(List<String> carNameList) {
        if (carNameList.stream().anyMatch(name -> name.trim().isEmpty())) {
            throw ExceptionMessage.NAME_BLANK.getException();
        }
    }

    public static void validateDuplicatedName(List<String> carNameList) {
        if (distinctCountOf(carNameList) != carNameList.size()) {
            throw ExceptionMessage.NAME_DUPLICATION.getException();
        }
    }

    public static void validateNameLength(List<String> carNameList) {
        for (String name : carNameList) {
            checkLengthOf(name);
        }
    }

    private static void checkLengthOf(String name) {
        if (name.length() > NAME_LIMIT_LENGTH) {
            throw ExceptionMessage.NAME_LENGTH.getException();
        }
    }

    private static long distinctCountOf(List<String> carNameList) {
        return carNameList.stream()
                .distinct()
                .count();
    }
}
