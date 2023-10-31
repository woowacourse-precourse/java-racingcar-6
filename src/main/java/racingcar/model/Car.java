package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MIN_NUM_RANGE = 0;
    private static final int MAX_NUM_RANGE = 9;
    private static final int MIN_DASH_CONDITION = 4;

    private CarInform carInform;
    private Car(String carName) {
        carInform = CarInform.newInstance(carName);
    }

    public static Car newInstance(String carName) {
        return new Car(carName);
    }

    public void dashByRandNum() {
        if(getRandNum() >= MIN_DASH_CONDITION) carInform.plusDash();
    }

    private int getRandNum() {
        return Randoms.pickNumberInRange(MIN_NUM_RANGE, MAX_NUM_RANGE);
    }

    public String getRacingResult() {
        return carInform.makeRacingResult();
    }

    public int getDashNum() {
        return carInform.getDashLen();
    }

    public String getWinnerName() {
        return carInform.getCarName();
    }

}
