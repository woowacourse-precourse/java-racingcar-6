package racingcar.domain;

public class Car {

    private final static int LIMIT_NAME_LENGTH = 6;
    private final static String CAR_NAME_LENGTH_FIVE_UNDER = "자동차의 이름은 5글자 이하만 가능합니다.";
    private final static String CAR_NAME_NO_BLANK = "자동차의 이름은 공백이 불가능합니다.";

    private final String name;
    private Integer distance = 0;

    public Car(String name) {
        validationNameLength(name);
        this.name = name;
    }

    // 자동차 이름은 5글자 이하만 가능합니다.
    public void validationNameLength(final String name) {
        if (name.length() >= LIMIT_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_FIVE_UNDER);
        }

        if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException(CAR_NAME_NO_BLANK);
        }
    }

    @Override
    public String toString() {
        return this.name + " : ";
    }

    public void accel() {
        distance++;
    }

    public String getName() {
        return name;
    }

    public Integer getDistance() {
        return distance;
    }
}
