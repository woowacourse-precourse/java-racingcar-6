package racingcar;

public class ExceptionString {
    static final String MAX_LENGTH_NAME = "자동차의 이름이 5자 초과입니다.";
    static final String BLANK_NAME = "이름이 공백 뿐입니다.";

    static void exceptionCheckName(String name) throws IllegalArgumentException {
        if(name.length() > ConstantNumber.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ExceptionString.MAX_LENGTH_NAME);
        }
        if(name.strip().isEmpty()) {
            throw new IllegalArgumentException(ExceptionString.BLANK_NAME);
        }
    }
}
