package racingcar.domain;

public class Car {

    private final String name;
    private int moveForwardCount;

    private Car(String name) {
        this.name = name;
    }

    public static Car createFromName(String name) {
        return new Car(name);
    }

    public void moveForward() {

    }

    public String getCurrentCondition() {
        return null;
    }

}
