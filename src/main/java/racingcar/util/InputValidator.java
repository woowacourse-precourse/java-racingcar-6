package racingcar.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    public static final int MIN_CAR_SIZE = 2;
    public static final int MIN_CAR_LENGTH = 5;
    public static final String REGEX = ",";

    public static void validateCarNamesSize(List<String> carNames) {
        if (carNames.size() < MIN_CAR_SIZE) {
            throw new IllegalArgumentException("2개 이상 입력해 주세요");
        }
    }

    public static void validateCharacter(String input) {
        boolean isNumber = input.chars().anyMatch(Character::isDigit);

        if (isNumber) {
            throw new IllegalArgumentException("문자만 입력해야 합니다.");
        }
    }

    public static void validateNameLength(List<String> carNames) {
        for(String carName : carNames) {
            if(carName.length() > MIN_CAR_LENGTH) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public static void validateRegex(String readLine) {
        if (!readLine.contains(REGEX)) {
            throw new IllegalArgumentException("쉼표로 구분되어야 합니다.");
        }
    }

    public static void validateDuplicate(List<String> cars) {
        Set<String> set = new HashSet<>(cars);

        if (set.size() != cars.size()) {
            throw new IllegalArgumentException("중복이 존재합니다.");
        }
    }

    public static void validateDigit(String readLine) {
        if (!readLine.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }
}
