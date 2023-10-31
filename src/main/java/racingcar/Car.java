package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String carName;
    private Integer position;

    public Car(String carName) {
        this.carName = carName;
        this.position = 0;
    }

    public String getCarName() {
        return carName;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public int move() {
        int randomNum = Randoms.pickNumberInRange(0, 9);

        if (randomNum >= 4) {
            position++;
        }
        return randomNum;
    }
}
