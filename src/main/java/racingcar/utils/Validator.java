package racingcar.utils;

import java.util.List;

public class Validator {
    private void validateInputCarOneToFive(List<String> input) {
        if (input.size() < 2 || input.size() > 5) {
            throw new IllegalArgumentException("자동차는 콤마로 구분하여 최소 두대 이상 최대 다섯대 이하로 입력해야 합니다.");
        }
    }

    private void validateInputCarNameIsEnglish(String input) {
        if (input == null || !input.chars().allMatch(Character::isLetter)) {
            throw new IllegalArgumentException("이름은 영문만 가능합니다.");
        }
    }

    private void validateInputCarNameLengthOneToFive(String input) {
        if (input.length() < 1 || input.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 한글자 이상, 다섯글자 이하로 입력해 주세요.");
        }
    }

    private void validateCarName(List<String> input) {
        for(String carName : input) {
            validateInputCarNameIsEnglish(carName);
            validateInputCarNameLengthOneToFive(carName);
        }
    }

    private void validateCarNameDuplicates(List<String> input) {
        List<String> distinctInput = input.stream()
                .distinct()
                .toList();
        if(distinctInput.size() < input.size()) {
            throw new IllegalArgumentException("자동차의 이름은 중복되어서는 안 됩니다.");
        };
    }

    private void validateNumeric(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("진행 횟수는 정수만 입력 가능합니다.");
            }
        }
    }

    private void validateMovingTryCountNull(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("시도하실 횟수를 정확하게 입력해 주세요.");
        }
    }

    private void validateOutOfMovingTryCountBoundary(String input) {
        int intInput = Integer.parseInt(input);
        if (intInput < 1 || intInput > 10) {
            throw new IllegalArgumentException("진행 횟수는 1회에서 10회 사이로만 가능합니다.");
        }
    }

    public void validateInputCar(List<String> input) {
        validateInputCarOneToFive(input);
        validateCarName(input);
        validateCarNameDuplicates(input);
    }

    public void validateInputMovingTryCount(String input) {
        validateMovingTryCountNull(input);
        validateNumeric(input);
        validateOutOfMovingTryCountBoundary(input);
    }

    public void validateInputCarNameStartOrEndComma(String input) {
        if (input.startsWith(",") || input.endsWith(",")) {
            throw new IllegalArgumentException("형식에 맞게 자동차 이름을 입력해 주세요.");
        }
    }
}