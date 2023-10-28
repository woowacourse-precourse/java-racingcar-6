package racingcar.car;

import racingcar.Constants;
import racingcar.Util;

public class Car {
    private final String NAME;
    private int position = 0;

    public Car(String name) {
        this.NAME = name;
        this.position = 0;
    }

    public void go(){
        if (Util.getRandomNum() >= Constants.GO_NUM) {
            position++;
        }
    }




}
