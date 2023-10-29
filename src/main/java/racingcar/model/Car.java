package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private CarInform carInform;
    private Car(String carName) {
        carInform = CarInform.newInstance(carName);
    }

    public static Car newInstance(String carName) {
        return new Car(carName);
    }

    public void dashByRandNum() {
        if(getRandNum() > 3) carInform.plusDash();
    }

    public int getRandNum() {
        return Randoms.pickNumberInRange(0, 9);
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
