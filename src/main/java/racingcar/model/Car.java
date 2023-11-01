package racingcar.model;

public class Car {
    private String name;
    private Integer moveStatus;

    public String getName() {
        return this.name;
    }

    public Integer getMoveStatus() {
        return this.moveStatus;
    }

    public Car(String name) {
        this.name = name;
        this.moveStatus = 0;
    }

    public void move() {
        this.moveStatus += 1;
    }
}
