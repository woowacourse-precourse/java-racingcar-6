package console;

public class Validator {

    private Validator() {}
    private static final int NAME_LIMIT = 5;

    public static void validateCarName(String name) {
        if (name.length() > NAME_LIMIT) throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
    }

    public static void validateCarNames(String[] carNames) {
        for (String name : carNames) {
            validateCarName(name);
        }
    }

    public static void validateTry(int tryCount) {
        if (tryCount <= 0 || tryCount >= 9) throw new IllegalArgumentException("입력값은 0에서 9 사이여야 합니다.");
    }
}
