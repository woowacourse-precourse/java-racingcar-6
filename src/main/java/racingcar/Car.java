package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String carName;
    private CarState carState;

    public Car(String carName) {

        this.carName = carName;
        determineCarState();
    }

    public CarState getCarState() {

        return carState;

    }

    private void determineCarState() {

        int randomNumber = Randoms.pickNumberInRange(0, 9);

        if (randomNumber <= 3) {

            this.carState = CarState.STOP;

        } else {

            this.carState = CarState.MOVE;

        }
    }
}
