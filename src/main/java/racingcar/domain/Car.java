package racingcar.domain;

public class Car {
    private String name;
    private int moveState;

    public Car(String name) {
        this.name = name;
        this.moveState = 0;
    }

    public String getName() {
        return name;
    }

    public int getMoveState() {
        return moveState;
    }


}
