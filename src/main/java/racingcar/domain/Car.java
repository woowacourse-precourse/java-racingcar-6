package racingcar.domain;

import racingcar.domain.constant.ConstNumber;
import racingcar.util.RaceUtil;

public class Car {

    private static int carNum;

    private final int id;
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
        this.id = carNum++;
    }

    public void move() {
        if (RaceUtil.isMove()) {
            this.position += ConstNumber.MOVE_DIST.getValue();
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
