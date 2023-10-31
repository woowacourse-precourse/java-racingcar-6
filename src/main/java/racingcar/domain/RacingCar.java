package racingcar.domain;

import static racingcar.Utils.repeatDash;
import static racingcar.constant.MessageConstants.DASH;
import static racingcar.constant.MessageConstants.WINNER_SUFFIX;
import static racingcar.constant.NumberConstants.MOVE_CONDITION;
import static racingcar.constant.NumberConstants.ZERO;

public class RacingCar {

    private final String carName;
    private int position = 0;

    public RacingCar(String carName) {
        this.carName = carName;
    }

    public boolean isWinner(int maxPosition) {
        return position == maxPosition;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_CONDITION) {
            position += 1;
        }
    }

    public String createRoundResult() {
        return carName + WINNER_SUFFIX + repeatDash(position);
    }

    public int createMaxPosition() {
        return position;
    }

    public String createWinnerName() {
        return carName;
    }

}
