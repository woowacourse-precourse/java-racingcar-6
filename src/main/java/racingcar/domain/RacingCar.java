package racingcar.domain;

import static racingcar.constant.MessageConstants.DASH;
import static racingcar.constant.MessageConstants.WINNER_SUFFIX;

import camp.nextstep.edu.missionutils.Randoms;

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
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position += 1;
        }
    }

    public String createRoundResult() {
        return carName + WINNER_SUFFIX + repeatDash();
    }

    private String repeatDash() {
        return DASH.repeat(Math.max(0, position));
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }

}
