package racingcar.domain;

public class Car {
    private static final int CAR_NAME_UPPER_LIMIT = 5;
    private String name;

    public Car(String name) {
        validateName(name);

        this.name = name;
    }

    private void validateName(String name) {
        try {
            name.charAt(CAR_NAME_UPPER_LIMIT);
        } catch (StringIndexOutOfBoundsException e) {
            return;
        }

        throw new IllegalArgumentException("자동차의 이름은 5글자 이하여야 합니다");
    }
}
