package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    public static final int MIN_RANDOM_RANGE = 0;
    public static final int MAX_RANDOM_RANGE = 9;
    public static final int MOVE_STANDARD = 4;

    private final String carName;
    private int carLocation;

    public Car(String carName) {
        this.carName = carName;
        this.carLocation = 0;
    }

    public void carMove() {
        if(Randoms.pickNumberInRange(MIN_RANDOM_RANGE,MAX_RANDOM_RANGE) >= MOVE_STANDARD) {
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
