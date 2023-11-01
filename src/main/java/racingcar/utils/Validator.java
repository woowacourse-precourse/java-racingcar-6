package racingcar.utils;

import java.util.List;

public class Validator {
    public static void checkCarNameLength(List<String> carsNameList) {
        carsNameList.stream()
                .filter(car -> car.length() >= 6)
                .findFirst()
                .ifPresent(car -> {
                        throw new IllegalArgumentException("입력 가능한 자동차의 이름은 5자 이하입니다.");
                });
    }

    public static void checkLength(List<String> carsNameList) {
        if (carsNameList.isEmpty()) {
            throw new IllegalArgumentException("1대 이상의 자동차 이름을 입력해주세요.");
        }
    }

    public static int checkDigit(String userInput) {
        try {
            int result = Integer.parseInt(userInput);
            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 회수는 숫자여야합니다.");
        }
    }
}
