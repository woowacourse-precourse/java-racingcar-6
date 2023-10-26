package racingcar.domain;

public class Car {

    private String name;

    private int forwordCount;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addForwordCount() {
        this.forwordCount++;
    }
}
