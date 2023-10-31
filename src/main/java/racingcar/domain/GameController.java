package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class GameController {

    private Integer moveForwardRandomNumber;

    public Integer getMoveForwardRandomNumber() {
        return moveForwardRandomNumber;
    }

    public void generateMoveForwardRandomNumber() {
        this.moveForwardRandomNumber = Randoms.pickNumberInRange(0,9);
    }

    public String getCarNamesInput() {
        return Console.readLine();
    }

    public void MoveForward(Car car, Integer moveForwardRandomNumber) {
        if (moveForwardRandomNumber > 3) {
            car.increaseSuccessMoveForwardCount();
        }
    }
}
