package racingcar;

public class Validator {
    public static void nameLengthCheck(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("잘못된 입력");
        }
    }
}
