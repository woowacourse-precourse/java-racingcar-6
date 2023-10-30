package racingcar.model;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String NAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 1-5글자이어야 함";

    private final String name;
    private int distance;


    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

}
