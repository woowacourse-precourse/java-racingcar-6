package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.RacingCar;
import racingcar.model.RacingCarList;

import static racingcar.view.OutputView.*;
import static racingcar.view.InputView.*;
import static racingcar.constant.GameConfig.*;

public class GameController {
    private final GameProcess process;

    public GameController() {
        process = new GameProcess();
    }

    public void run() {
        String namesOfRacingCars = getPlayerInput();
        RacingCarList car = new RacingCarList(namesOfRacingCars);
        int tryAttempt = getPlayerAttempts();

        gameResultMessge();
        while (tryAttempt > ZERO.getValue()) {
            process.processGame(car);
            tryAttempt -= 1;    // 메서드 호출하는걸로 바꾸기
        }
        printFinalWinner(getFinalWinner(car));
    }

    private List<String> getFinalWinner(RacingCarList racingCarList) {
        int maxDistance = ZERO.getValue();
        List<String> result = new ArrayList<>();
        for (int carIndex = 0; carIndex < racingCarList.size(); carIndex++) {
            RacingCar car = racingCarList.getCar(carIndex);
            int carDistance = car.getDistance();

            if (carDistance > maxDistance) {
                result.clear();
                maxDistance = carDistance;
            }
            if (car.getDistance() == maxDistance) {
                result.add(car.getName());
            }
        }
        return result;
    }
}
