package racingcar;

import java.util.List;

public class Validator {

    public static void isValidateCarName(List<String> carNameList) {
        isEmpty(carNameList);
        isValidCarNameRange(carNameList);
        isDuplicated(carNameList);
    }

    public static void isValidateRoundTimeNumber(String input) {
        isEmpty(input);
        isDigit(input);
        isValidDigit(input);
    }

    private static void isEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력된 값이 없습니다.");
        }
    }

    private static void isEmpty(List<String> inputList) {
        if (inputList.isEmpty()) {
            throw new IllegalArgumentException("입력된 값이 없습니다.");
        }

        for (String input: inputList) {
            if (input.isEmpty()) {
                throw new IllegalArgumentException("입력된 값이 없습니다.");
            }
        }
    }

    private static void isValidCarNameRange(List<String> inputList) {
        for (String input : inputList) {
            if (input.length() > 5) {
                throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    private static void isDuplicated(List<String> inputList) {
        if (inputList.stream().distinct().toList().size() != inputList.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 존재합니다.");
        }
    }

    private static void isDigit(String input) {
        try {
            int num = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private static void isValidDigit(String input) {
        if (Integer.valueOf(input) <= 0) {
            throw new IllegalArgumentException("이동을 시도할 횟수는 자연수이어야 합니다.");
        }
    }
}
