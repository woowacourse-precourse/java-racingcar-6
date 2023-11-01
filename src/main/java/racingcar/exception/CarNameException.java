package racingcar.exception;

import java.util.HashSet;
import java.util.List;

public class CarNameException {
    private final static String INVALID_CAR_NAME_LENGTH_MSG = "자동차 이름의 길이는 5이하입니다.";
    private final static String CAR_NAME_EMPTY_MSG = "비어있는 차 이름이 존재합니다.";
    private final static String CAR_NAME_BLANK_MSG = "공백인 이름의 차가 존재합니다.";
    private final static String CAR_NAME_ENG = "차 이름은 영문으로만 이루어져야합니다.";
    private final static String CAR_NAME_DUPLICATE = "차 이름은 중복될 수 없습니다.";
    private final static int CAR_NAME_LENGTH = 5;
    private final static char CAR_NAME_BLANK = ' ';
    private final static String CAR_NAME_REGEX = "^[a-zA-Z]*$";

    public static void validateCarNameLength(String name) {
        if (name.length() > CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH_MSG);
        }
    }

    public static void validateCarNameEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(CAR_NAME_EMPTY_MSG);
        }
    }

    public static void validateCarNameBlank(String name) {
        for (char c : name.toCharArray()) {
            if (c != CAR_NAME_BLANK) {
                return;
            }
            throw new IllegalArgumentException(CAR_NAME_BLANK_MSG);
        }
    }

    public static void validateCarNameEng(String name) {
        if (!name.matches(CAR_NAME_REGEX)) {
            throw new IllegalArgumentException(CAR_NAME_ENG);
        }
    }

    public static void validateCarNameDuplicate(List<String> names) {
        int nameSize = names.size();
        HashSet<String> nonDuplicateCars = new HashSet<>(names);
        if (nameSize != nonDuplicateCars.size()) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE);
        }
    }

}
