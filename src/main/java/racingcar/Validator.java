package racingcar;

public class Validator {

    public static void validateIsBlank(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException("잘못된 입력값입니다.(빈칸 혹은 공백)");
        }
    }
}