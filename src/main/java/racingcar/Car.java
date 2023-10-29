package racingcar;

public class Car {
    final String name;
    int forwardNumber;

    public Car(final String name, int forwardNumber) {
        this.name = name;
        this.forwardNumber = forwardNumber;
    }

    public Car(final String name) {
        this.name = name;
    }

}
