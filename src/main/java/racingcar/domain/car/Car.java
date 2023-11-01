package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String carName;
    private int carLocation;

    public Car(String carName) {
        this.carName = carName;
        this.carLocation = 0;
    }

    public void carMove() {
        if(Randoms.pickNumberInRange(0,9) >= 4) {
            carLocation += 1;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getCarLocation() {
        return carLocation;
    }
}
