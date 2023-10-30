package racingcar.model;

public class Car {
    private String carName;
    private int position;

    private final static String NOT_VALID_CAR_NAME = "자동차 이름의 길이가 1-5자 사이가 아닙니다.";
    private final static int VALID_MINIMUM_NUMBER = 1;
    private final static int VALID_MAXIMUM_NUMBER = 5;


    private Car(String carName) {
        validateCarName(carName);
        this.carName = carName;
        this.position = 0;
    }

    public static Car from(String carName) {
        return new Car(carName);
    }

    private void validateCarName(String carName) {
        if (carName.length() < VALID_MINIMUM_NUMBER || carName.length() > VALID_MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(NOT_VALID_CAR_NAME);
        }
    }

    public void moveForward() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.carName;
    }
}
