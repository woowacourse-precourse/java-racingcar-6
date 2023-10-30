package racingcar.model;

public class Car {
    private String name;
    private Long movingCount;

    public Car(String name) {
        this.name = name;
        movingCount = 0L;
    }
}