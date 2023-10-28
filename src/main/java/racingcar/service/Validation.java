package racingcar.service;

import java.util.Arrays;

public class Validation {

    public void validateUserInput(String inputCarName) {
        String[] carNames = inputCarName.split(",");

        if (!Arrays.stream(carNames).allMatch(Validation::isCarNameLengthValid)) {
            throw new IllegalArgumentException("5글자를 초과하는 이름은 입력할 수 없습니다. 사용자의 입력 : " + inputCarName);
        }
        if (!Arrays.stream(carNames).allMatch(Validation::isNumeric)) {
            throw new IllegalArgumentException("이름에 숫자가 들어갈 수 없습니다.");
        }
    }

    public void validateMovement(Integer movement) {
        if (movement == null || String.valueOf(movement).trim().isEmpty()) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }

        try {
            Integer.parseInt(String.valueOf(movement));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("문자열이 아닌 숫자를 입력해주세요.");
        }
    }

    private static Boolean isCarNameLengthValid(String carName) {
        return carName.length() <= 5;
    }

    private static boolean isNumeric(String carName) {
        return !carName.matches(".*\\d.*");
    }
}
