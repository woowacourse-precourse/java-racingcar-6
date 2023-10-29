package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class GameController {

    private Integer TryMoveForwardRandomNumber;

    public void generateTryMoveForwardRandomNumber() {
        this.TryMoveForwardRandomNumber = Randoms.pickNumberInRange(0,9);
    }

    public String getCarNamesInput() {
        return Console.readLine();
    }

    public void MoveForward(List<Car> carList) {
        for (Car car : carList) {
            this.generateTryMoveForwardRandomNumber();
            if (this.TryMoveForwardRandomNumber > 3) {
                car.increaseSuccessMoveForwardCount();
            }
        }
    }

    public void setRacingProgressStatus(List<Car> carList) {
        for (Car car : carList) {
            car.setMoveForwardStatus();
        }
    }
}
