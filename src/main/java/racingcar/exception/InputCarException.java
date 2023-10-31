package racingcar.exception;

public class InputCarException {
    private static final String NAME_LENGTH_MESSAGE = "자동차의 이름은 5자 이하만 가능합니다.";
    public static void nameLengthException(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(NAME_LENGTH_MESSAGE + " name : " + name);
        }
    }

    public static void numberOfCarException() {

    }
}