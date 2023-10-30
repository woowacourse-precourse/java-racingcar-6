package racingcar.car;

import racingcar.Constants;
import racingcar.Util;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void go(){
        if (Util.getRandomNum() >= Constants.GO_NUM) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
