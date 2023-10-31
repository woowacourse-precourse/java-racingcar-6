package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.model.CarModel;

public class RacingGameController {
    private final List<CarModel> carList;
    private static final int CAN_FORWARD = 4;
    public RacingGameController(List<CarModel> carList) {
        this.carList = carList;
    }

    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public boolean isUpperThanCanForwardNumber(int targetNumber) {
        return targetNumber >= CAN_FORWARD;
    }
}
