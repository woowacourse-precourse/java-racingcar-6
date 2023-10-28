package racingcar.model;

public class Car {
    private String name;
    private String moveState;

    public Car(String name) {
        this.name = name;
        this.moveState = "";
    }

    public void move(Integer moveCount) {
        for (int i = 0; i < moveCount; i++) {
            moveState += "-";
        }
    }
}
