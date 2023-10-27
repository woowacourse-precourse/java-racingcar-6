package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String carName;
    private String distanceDriven = "";
    public Car(String carName) {
        this.carName = carName;
    }

    public int createRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }
}
