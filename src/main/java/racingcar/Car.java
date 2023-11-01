package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    public static final int MIN_RANGE = 0;
    public static final int MAX_RANGE = 9;
    public static final int MOVE_STANDARD = 4;

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
        int randomNum = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);

        if (randomNum >= MOVE_STANDARD) {
            position++;
        }
        return randomNum;
    }
}
