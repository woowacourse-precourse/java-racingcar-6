package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String carName;
    private String distanceDriven = "";

    public Car(String carName) {
        this.carName = carName;
    }

    public int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void moveForward(int randomNum) {
        if (randomNum >= 4) {
            this.distanceDriven += "-";
        }
    }

    public void driving() {
        int randomNum = createRandomNumber();
        moveForward(randomNum);
    }

    public String getCarName() {
        return carName;
    }

    public String getDistanceDriven() {
        return distanceDriven;
    }
}
