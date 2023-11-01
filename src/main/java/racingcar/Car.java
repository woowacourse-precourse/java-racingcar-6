package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String carName;
    private int carPosition;

    public Car(String name, int position) {
        this.carName=name;
        this.carPosition=position;
    }

    public String returnCarName() {
        return carName;
    }
    public void setCarPosition() {
        this.carPosition += 1;
    }
    public int returnCarPosition() {
        return carPosition;
    }

}
