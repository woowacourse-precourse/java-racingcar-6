package racingcar.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class CarInputValidation {

    public void validateCarInput(String input) {
        validateDuplicateNames(input);
        validateNoSpaces(input);
        validateNameLength(input);
        validateMinCarCount(input);
        validateTrailingComma(input);
        validateCaseRedundancy(input);
        validateSpecialCharacters(input);
    }

    private void validateDuplicateNames(String input) {
        String[] inputCars = input.split(",");
        Set<String> names = new HashSet<>(Arrays.asList(inputCars));
        if (names.size() < inputCars.length) {
            throw new IllegalArgumentException("중복된 자동차 이름이 존재합니다.");
        }
    }

    private void validateNoSpaces(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름에 공백이 포함되어 있습니다.");
        }
    }

    private void validateNameLength(String input) {
        String[] inputCars = input.split(",");
        for (String name : inputCars) {
            if (name.length() < 1 || name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 1자에서 5자 사이어야 합니다.");
            }
        }
    }

    private void validateMinCarCount(String input) {
        String[] inputCars = input.split(",");
        if (inputCars.length < 2) {
            throw new IllegalArgumentException("최소 2대의 자동차 이름을 입력해야 합니다.");
        }
    }

    private void validateTrailingComma(String input) {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException("마지막 자동차 이름 뒤에 쉼표(,)를 입력하지 마세요.");
        }
    }

    private void validateCaseRedundancy(String input) {
        String[] inputCars = input.split(",");
        Set<String> names = new HashSet<>();
        for (String name : inputCars) {
            String normalizedName = name.toLowerCase();
            if (names.contains(normalizedName)) {
                throw new IllegalArgumentException("대소문자를 구분하지 않고 중복된 자동차 이름은 허용되지 않습니다.");
            }
        }
    }

    private void validateSpecialCharacters(String input) {
        String[] inputCars = input.split(",");
        for (String name : inputCars) {
            if (!Pattern.matches("^[a-zA-Z0-9-_.]*$", name)) {
                throw new IllegalArgumentException("자동차 이름에 허용되지 않는 특수 문자가 포함되어 있습니다.");
            }
        }
    }
}
