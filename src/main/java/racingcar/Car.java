package racingcar;

public class Car {

    private String name;
    private Integer forwardCount;

    private static final int DEFAULT_FORWARD_COUNT = 0;

    public Car(String name) {
        this.name = name;
        this.forwardCount = DEFAULT_FORWARD_COUNT;
    }
}
