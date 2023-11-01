package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String carName;
    private int position;
    public Car(String carName) {
        this.carName = carName;
        this.position = 0;
    }

    public void move() {
       int randomNumber = Randoms.pickNumberInRange(0, 9);
       if (randomNumber >= 4) {
           position++;
       }
    }
    public int getPosition() {
        return position;
    }
    public String getCarName() {
        return carName;
    }
}
