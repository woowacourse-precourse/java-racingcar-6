package racingcar.utils;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Validator {
    private final static String NAME_EXCEPTION = "잘못된 형식의 이름입니다.";
    private static final String EMPTY_EXCEPTION = "입력 값이 비어있습니다.";
    private static final String REPEAT_NUMBER_EXCEPTION = "1이상의 숫자를 입력하세요.";
    private static final String DUPLICATE_NAME_EXCEPTION = "같은 이름의 참가자는 존재할 수 없습니다";

    public void checkCarName(String carName) {
        isEmptyInput(carName);
        if (!isValidName(carName)) {
            throw new IllegalArgumentException(NAME_EXCEPTION);
        }
    }

    public void checkRepeatNumber(String repeatNumber) {
        if (!isValidRepeatNumber(repeatNumber)) {
            throw new IllegalArgumentException(REPEAT_NUMBER_EXCEPTION);
        }
    }

    public void checkDuplicateName(List<String> stringNames) {
        if (isDuplicateNameExist(stringNames)) {
            throw new IllegalArgumentException(DUPLICATE_NAME_EXCEPTION);
        }
    }


    private boolean isValidName(String carName) {
        // 입력 값이 대소문자 알파벳이며 1~5자리 숫자일 경우
        String regex = "^[a-zA-Z]{1,5}$";
        return Pattern.matches(regex, carName);
    }

    private boolean isValidRepeatNumber(String repeatNumber) {
        String regex = "[1-9]\\d*";
        return Pattern.matches(regex, repeatNumber);
    }

    private boolean isDuplicateNameExist(List<String> stringNames) {
        Set<String> nameSet = new HashSet<>(stringNames);
        return nameSet.size() != stringNames.size();
    }

    private void isEmptyInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_EXCEPTION);
        }
    }
}
