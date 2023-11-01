package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.RacingConstant;
import racingcar.constant.RandNumConstant;

public class Car {
    private CarInform carInform;
    private Car(String carName) {
        carInform = CarInform.newInstance(carName);
    }

    public static Car newInstance(String carName) {
        return new Car(carName);
    }

    public void dashByRandNum() {
        if(getRandNum() >= RacingConstant.MIN_DASH_CONDITION.getValue()) carInform.plusDash();
    }

    private int getRandNum() {
        return Randoms.pickNumberInRange(RandNumConstant.MIN_NUM_RANGE.getValue(), RandNumConstant.MAX_NUM_RANGE.getValue());
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
