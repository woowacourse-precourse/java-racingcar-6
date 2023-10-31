package racingcar.domain;

public class Validate {
    public static void validatePositiveNumber(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다, 자연수를 입력해 주세요");
        }
    }

    public static boolean validateName(String name) {
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다, 이름이 비어있습니다.");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다, 이름이 5글자가 넘습니다.");
        }

        if (name.contains(" ")) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다, 이름에는 스페이스 바가 들어갈 수 없습니다.");
        }

        return true;
    }
}
