package racingcar.domain;

public class Car {
    private String name;
    private int moving;

    public Car(String name) {
        this.name = name;
        this.moving = 0;
    }

    public String getName() {
        return name;
    }

    public int getMoving() {
        return moving;
    }

    public void oneMoving() {
        moving += 1;
    }
}
