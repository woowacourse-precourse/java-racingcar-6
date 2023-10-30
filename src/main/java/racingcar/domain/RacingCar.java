package racingcar.domain;

import static racingcar.constant.MessageConstants.DASH;
import static racingcar.constant.MessageConstants.WINNER_SUFFIX;
import static racingcar.constant.NumberConstants.MAX_MOVE_CONDITION;
import static racingcar.constant.NumberConstants.MIN_MOVE_CONDITION;
import static racingcar.constant.NumberConstants.MOVE_CONDITION;
import static racingcar.constant.NumberConstants.ZERO;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RacingCar {

    private final String carName;
    private int position = 0;

    public RacingCar(String carName) {
        this.carName = carName;
    }

    public boolean isWinner(int maxPosition) {
        return position == maxPosition;
    }

    public void move() {
        if (Randoms.pickNumberInRange(MIN_MOVE_CONDITION, MAX_MOVE_CONDITION) >= MOVE_CONDITION) {
            position += 1;
        }
    }

    public String createRoundResult() {
        return carName + WINNER_SUFFIX + repeatDash();
    }

    private String repeatDash() {
        return DASH.repeat(Math.max(ZERO, position));
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }

}
