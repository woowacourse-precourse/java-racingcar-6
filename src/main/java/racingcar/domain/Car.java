package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.GameRule;
import racingcar.view.OutputView;

public class Car {
    private String name;
    private int moveCnt;

    public Car(String name) {
        this.name = name;
        this.moveCnt = 0;
    }

    public int generateNumber() {
        return Randoms.pickNumberInRange(GameRule.MIN_INPUT_NUMBER, GameRule.MAX_INPUT_NUMBER);
    }

    public void moveForward(int randomNumber) {
        if (isMove(randomNumber)) {
            moveCnt++;
        }
    }

    public boolean isMove(int randomNumber) {
        return randomNumber >= GameRule.MOVING_FORWARD;
    }

    public void printCurrentPosition() {
        OutputView.printCurrentPosition(name, moveCnt);
    }
}
