package racingcar;

public class InputException {
    static final String MAX_LENGTH_NAME = "자동차의 이름이 5자 초과입니다.";
    static final String BLANK_NAME = "이름이 공백 뿐입니다.";
    static final String SAME_NAME = "같은 이름을 가지고 있습니다.";
    static final String NOT_INTEGER = "입력한 내용이 숫자가 아닙니다.";
    static final String NEGATIVE_OR_ZERO = "입력한 숫자가 0이나 음수입니다.";

    static void exceptionCheckName(String name) throws IllegalArgumentException {
        name = name.trim();
        if(name.isEmpty()) {
            throw new IllegalArgumentException(InputException.BLANK_NAME);
        }
        if(name.length() > ConstantNumber.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(InputException.MAX_LENGTH_NAME);
        }
    }
}
