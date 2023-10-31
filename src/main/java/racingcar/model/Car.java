package racingcar.model;

import java.util.stream.IntStream;
import racingcar.constants.GameInfo;
import racingcar.controller.RacingGameController;
import racingcar.util.GameUtil;

public class Car {

    private final String carName;
    private int position;

    public Car(String carName) {
        this.carName = carName;
        this.position = 0;
    }

    public void move() {
        if (GameUtil.getMoveOrStop()) {
            position++;
            RacingGameController.updateMaxPosition(position);
        }
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append(carName).append(" : ");
        IntStream.range(0, position).forEach(i -> sb.append(GameInfo.CAR_MOVE_SYMBOL));
        System.out.println(sb);
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }
}
