package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String carName;

    private CarState carState;

    private int carPosition;

    public Car(String carName) {

        this.carName = carName;

        determineCarState();
    }

    public String getCarName() {

        return carName;
    }

    public int getCarPosition() {

        return carPosition;

    }

    public void determineCarState() {

        int randomNumber = Randoms.pickNumberInRange(0, 9);

        if (randomNumber > 3) {

            carState = CarState.MOVE;
            carPosition++;

        } else {

            carState = CarState.STOP;

        }
    }

    public String getCarStateMessage() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("-".repeat(Math.max(0, carPosition)));

        return stringBuilder.toString();
    }
}
