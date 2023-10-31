package racingcar.model;

import racingcar.constants.GameInfo;
import racingcar.util.GameUtil;

public class Car {

    private final String car;
    private int position;

    public Car(String car) {
        this.car = car;
        this.position = 0;
    }

    public void move() {
        if (GameUtil.getMoveOrStop()) {
            position++;
        }
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append(car).append(" : ");
        for (int i = 0; i < position; i++) {
            sb.append(GameInfo.CAR_MOVE_SYMBOL);
        }
        System.out.println(sb);
    }
}
