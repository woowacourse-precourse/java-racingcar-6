package racingcar.model;

import racingcar.util.Utils;

public class Car {
    final static int START_POSITION = 0;
    private String carName;
    private int carPosition = START_POSITION;

    public Car(String carName) {
        this.carName = carName;
        this.carPosition = START_POSITION;
    }

    public void goForward() {
        if (Utils.generateNumber() > 3) {
            this.carPosition++;
        }
    }

    public int getCarPosition() {
        return this.carPosition;
    }

    public String getCarName() {
        return this.carName;
    }

    public boolean checkWinner(int maxNumber) {
        return this.carPosition == maxNumber;
    }
}
