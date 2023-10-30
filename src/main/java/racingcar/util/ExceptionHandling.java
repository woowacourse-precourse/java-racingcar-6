package racingcar.util;

import java.util.List;

public class ExceptionHandling {
    public static void isCarNameNull(String carName) throws IllegalArgumentException {
        if (carName.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백이 될수 없습니다.");
        }
    }

    public static void isCarNameSame(String carName, List<String> carList) throws IllegalArgumentException {
        if (carList.contains(carName)) {
            throw new IllegalArgumentException("자동차 이름은 중복이 될수 없습니다.");
        }
    }

    public static void isCarNameOverSize(String carName) throws IllegalArgumentException {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하 이여야 합니다.");
        }
    }

    public static void isNumberZero(String number) throws IllegalArgumentException {
        if (number.equals("0")) {
            throw new IllegalArgumentException("0은 입력할 수 없습니다");
        }
    }

    public static void isNumberValid(String number) throws IllegalArgumentException {
        if (!number.matches("\\d+")) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }
}
