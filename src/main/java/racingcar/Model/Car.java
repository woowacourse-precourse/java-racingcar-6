package racingcar.Model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    public final String carName;
    public int carPosition;

    public Car(String carName) {
        this.carName = carName;
        this.carPosition = 0;
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            carPosition++;
        }
    }
}
