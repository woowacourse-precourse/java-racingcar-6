package racingcar.domain;

public class CarName {

    private static final int MAXIMUM_LENGTH = 5;

    private final String value;

    private CarName(String value) {
        this.value = value;
    }

    public static CarName from(String value) {
        validateLength(value);
        return new CarName(value);
    }

    private static void validateLength(String value) {
        int valueLength = value.length();
        if (valueLength > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5글자 이하만 가능합니다. 주어진 이름은 " + valueLength + "글자 입니다.");
        }
    }

}
