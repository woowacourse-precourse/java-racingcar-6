package racingcar;

public class Car {
    private final String name;
    private int forwardNumber;

    public Car(String name, int forwardNumber) {
        this.name = name;
        this.forwardNumber = forwardNumber;
    }

    public Car(String name) {
        this.name = name;
    }

}
