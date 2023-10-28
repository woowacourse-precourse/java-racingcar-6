package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private CarInform carInform;
    private Car(String carName) {
        carInform = CarInform.getInstance(carName);
    }

    public static Car getInstance(String carName) {
        return new Car(carName);
    }

    public void getRandNum() {
        int randNum = Randoms.pickNumberInRange(0, 9);
    }
}
