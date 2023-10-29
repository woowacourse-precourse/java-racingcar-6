package racingcar.model;

public class Car {

    private String name;
    private int forwardNumber;

    public Car(String name) {
        this.name = name;
        forwardNumber = 0;
    }

    public String getName() {
        return name;
    }

    public int getForwardNumber() {
        return forwardNumber;
    }

    public void increaseForwardNumber() {
        forwardNumber++;
    }
}
