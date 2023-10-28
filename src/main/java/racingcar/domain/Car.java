package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int position;
    public Car(String name) {
        this.name = name;
        position = 0;
    }

    public void move() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum >= 4) {
            position += randomNum;
        }
    }

    public String getCarName() {
        return name;
    }

    public int getCarPosition() {
        return position;
    }
}
