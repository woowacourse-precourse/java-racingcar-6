package racingcar.model;

public class CarName {
    private String name;
    private final static String NOT_VALID_CAR_NAME = "자동차 이름의 길이가 1-5자 사이가 아닙니다.";
    private final static int VALID_MINIMUM_NUMBER = 1;
    private final static int VALID_MAXIMUM_NUMBER = 5;

    public CarName(String name) {
        if (name.length() < VALID_MINIMUM_NUMBER || name.length() > VALID_MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(NOT_VALID_CAR_NAME);
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
