package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.util.RacingGameUtil;
import racingcar.view.InputManager;

public class GameController {
    List<Car> cars = new ArrayList<>();
    public void run() {
        String carNames = getCarNameFromUser();
        makeCar(carNames);
    }

    private void makeCar(String carNames) {
        List<String> carNameList = RacingGameUtil.splitCarNames(carNames);
    }

    private String getCarNameFromUser() {
        InputManager.requestCarName();
        return Console.readLine();
    }
}
