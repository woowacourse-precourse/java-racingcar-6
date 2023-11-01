package racingcar.domain;

import java.util.List;

public class Verification {

    public static void throwCarNameLengthException(String carName) {
        if (carName.lastIndexOf(",") == carName.length() - 1) {
            throw new IllegalArgumentException("자동차 이름은 한 글자 이상 입력하세요");
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }
    public static void checkEqualsAndThrowException(List<String> carName) {
        if (carName.size() != carName.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 이름입니다.");
        }
    }

    public static void validateNonNumeric(String input) { //숫자가 아닐 때
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수로 입력해주세요.");
        }
    }

}
