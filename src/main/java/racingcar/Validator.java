package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Validator {
    public static final int MAX_NAME_LENGTH = 5;
    public static final String NAME_LENGTH_ERROR_MESSAGE = "이름은 5자 이하만 가능합니다.";
    public static final String NAME_DUPLICATE_ERROR_MESSAGE = "중복된 이름이 존재합니다.";
    public static final String BLANK_STRING = "";
    public static final String INVALID_INPUT_ERROR_MESSAGE = "잘못된 값이 입력되었습니다.";
    public static final String ZERO_INPUT_ERROR_MESSAGE = "0이 아닌 양의 정수 입력해주세요.";
    public static final int VALID_NUMBER_RANGE_START = '0';
    public static final int VALID_NUMBER_RANGE_END = '9';


    public static void nameLengthCheck(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    public static void nameDuplicatenCheck(List<String> names) {
        int initLength = names.size();
        HashSet<String> deduplicationSet = new HashSet<>(names);
        if (initLength != deduplicationSet.size()) {
            throw new IllegalArgumentException(NAME_DUPLICATE_ERROR_MESSAGE);
        }
    }

    public static void blankCheck(String input) {
        if (Objects.equals(input, BLANK_STRING)) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR_MESSAGE);
        }
    }

    public static void countZeroCheck(String input) {
        if (input.length() == 1 && input.charAt(0) == '0') {
            throw new IllegalArgumentException(ZERO_INPUT_ERROR_MESSAGE);
        }
    }

    public static void countNumericCheck(String input) {
        for (int i = 0; i < input.length(); i++) {
            char inputChar = input.charAt(i);
            if (!(VALID_NUMBER_RANGE_START <= inputChar && inputChar <= VALID_NUMBER_RANGE_END)) {
                throw new IllegalArgumentException(INVALID_INPUT_ERROR_MESSAGE);
            }
        }
    }

}
