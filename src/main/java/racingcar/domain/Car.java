package racingcar.domain;

import static racingcar.enums.CarConstant.CAN_FORWARD_NUMBER;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void go() {
        position++;
    }

    public boolean canGo(int number) {
        return number >= CAN_FORWARD_NUMBER.getNumber();
    }

    public boolean isWinner(int winnerPosition) {
        return this.position == winnerPosition;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
