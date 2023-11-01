package racingcar.model;

public class Car {
    private String name;
    private int movement;

    public Car(String name) {
        this.name = name;
        this.movement = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getMovement() {
        return this.movement;
    }

    public void updateMovement() {
        this.movement++;
    }
}
