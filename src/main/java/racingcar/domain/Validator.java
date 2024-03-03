package racingcar.domain;

public class Validator {
    private static final int MAX_LENGTH = 5;

    public static boolean validateSize(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
        return true;
    }
}
