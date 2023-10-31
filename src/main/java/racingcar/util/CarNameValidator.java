package racingcar.util;

public class CarNameValidator {
    private static final String SPACE = " ";

    public static void validateSpaceCheck(String carName) {
        if (carName.contains(SPACE)) {
            throw new IllegalArgumentException("이름에 공백이 존재할 수 없습니다.");
        }
    }

    public static void validateLengthCheck(String carName,int legth) {
        if (carName.length() > legth) {
            throw new IllegalArgumentException(String.format("이름의 길이는 %d를 초과할 수 없습니다.", legth));
        }
    }

    public static void validateEmptyCheck(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("이름을 입력하지 않았습니다.");
        }
    }
}
