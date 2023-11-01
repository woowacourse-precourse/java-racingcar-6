package racingcar.validation;

import java.util.List;

public class NameInputValidator {
    private static final int MIN_INPUT_LENGTH = 1;
    private static final int MAX_INPUT_LENGTH = 5;
    private final static String LENGTH_EXCEPTION_MESSAGE = "이름의 길이가 잘못됐습니다.";
    private final static String DUPLICATION_EXCEPTION_MESSAGE = "이름이 중복됐습니다.";
    private final static String EMPTY_STRING_EXCEPTION_MESSAGE = "이름이 공백입니다.";

    public void validateInput(List<String> nameList) {
        checkInputDuplication(nameList);
        for (String name : nameList) {
            checkInputLengthValidity(name);
            checkInputEmptyString(name);
        }
    }

    private void checkInputLengthValidity(String input) {
        if (input.length() > MAX_INPUT_LENGTH || input.length() < MIN_INPUT_LENGTH) {
            throw new IllegalArgumentException(LENGTH_EXCEPTION_MESSAGE);
        }
    }

    private void checkInputDuplication(List<String> nameList) {
        int distinctNameListSize = (int) nameList.stream()
                .distinct()
                .count();

        if (nameList.size() != distinctNameListSize) {
            throw new IllegalArgumentException(DUPLICATION_EXCEPTION_MESSAGE);
        }
    }

    private void checkInputEmptyString(String input) {
        if (input.trim().equals("")) {
            throw new IllegalArgumentException(EMPTY_STRING_EXCEPTION_MESSAGE);
        }
    }
}
