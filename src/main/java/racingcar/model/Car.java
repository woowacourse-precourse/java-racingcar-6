package racingcar.model;

public class Car {

    private final String name;
    private Integer moveCount;

    public Car(String name) {
        this.name = name;
        this.moveCount = 0;
    }
}
