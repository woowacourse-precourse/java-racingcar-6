package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.constant.NumberConstant.CAN_FORWARD_NUMBER;
import static racingcar.constant.NumberConstant.MAX_RANDOM_NUMBER;
import static racingcar.constant.NumberConstant.MIN_RANDOM_NUMBER;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void go() {
        int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        if (randomNumber >= CAN_FORWARD_NUMBER) {
            position++;
        }
    }

    public boolean isWinner(int winnerPosition) {
        return this.position == winnerPosition;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
