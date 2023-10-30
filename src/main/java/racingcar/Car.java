package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String carName;
    private String distanceDriven = "";

    public Car(String carName) {
        this.carName = carName;
    }

    public void driving() {
        int randomNum = createRandomNumber();
        isCarGoForward(randomNum);
    }

    private int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private void isCarGoForward(int randomNum) {
        if (randomNum >= 4) {
            this.distanceDriven += "-";
        }
    }

    public String getCarName() {
        return carName;
    }

    public String getDistanceDriven() {
        return distanceDriven;
    }
}
