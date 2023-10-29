package racingcar.model;

import racingcar.constants.CarConstant;

public class Car {

    private String name;
    private int position = CarConstant.INITIAL_POSITION.getValue();

    private Car(String name) {
        this.name = name;
    }

    public static Car from(String name) {
        return new Car(name);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward(int randomNumber) {
        if (randomNumber >= CarConstant.MOVE_NUMBER.getValue()) {
            position++;
        }
    }

    public boolean isWinner(int maxPosition) {
        return position == maxPosition;
    }
}
