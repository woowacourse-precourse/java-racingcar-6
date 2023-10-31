package racingcar;

import java.util.HashSet;
import java.util.Set;

public class CarNameValidator {

    private static final Set<String> checkNameDuplicateList = new HashSet<>();
    private static final char NAME_SEPARATOR = ',';
    private static final String DOUBLE_USE_SEPARATOR = ",,";
    private static final int NAME_MAX_LENGTH = 5;
    private static final char BLANK = ' ';

    public void checkEmptyInput(String readLine) {
        if (readLine.isBlank()) {
            throw new IllegalArgumentException("빈칸이 입력되었습니다.");
        }
    }

    public void checkInvalidSeparator(String readLine) {
        if (readLine.charAt(0) == NAME_SEPARATOR) {
            throw new IllegalArgumentException(",으로 시작할 수 없습니다.");
        }
        if (readLine.charAt(readLine.length() - 1) == NAME_SEPARATOR) {
            throw new IllegalArgumentException(",으로 끝날 수 없습니다.");
        }
        if (readLine.contains(DOUBLE_USE_SEPARATOR)) {
            throw new IllegalArgumentException("쉼표를 연속으로 사용하였습니다.");
        }
    }

    public void checkNameLength(String carName) {
        if (carName.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

    public void checkNameBlankStart(String carName) {
        if (carName.charAt(0) == BLANK) {
            throw new IllegalArgumentException("이름이 공백으로 시작하면 안됩니다.");
        }
    }

    public void checkNameBlankEnd(String carName) {
        if (carName.charAt(carName.length() - 1) == BLANK) {
            throw new IllegalArgumentException("이름이 공백으로 끝나면 안됩니다.");
        }
    }

    public void checkNameDuplicate(String carName) {
        if (!checkNameDuplicateList.add(carName)) {
            throw new IllegalArgumentException("중복된 이름이 입력되었습니다.");
        }
    }
}
