package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.constant.GameConfig;
import racingcar.model.RacingCar;
import racingcar.model.RacingCarList;

import static racingcar.view.OutputView.*;
import static racingcar.view.InputView.*;
import static racingcar.constant.GameConfig.*;

public class GameController {
    private final GameProcess process;
    private int ZERO = GameConfig.ZERO.getValue();

    public GameController() {
        process = new GameProcess();
    }

    public void run() {
        String namesOfRacingCars = getPlayerInput();
        RacingCarList car = new RacingCarList(namesOfRacingCars);
        int tryAttempt = getPlayerAttempts();

        gameResultMessge();
        while (tryAttempt > ZERO) {
            process.processGame(car);
            tryAttempt = decreaseAttempt(tryAttempt);
        }
        printFinalWinner(getFinalWinner(car, car.size()));
    }
    private int decreaseAttempt(int attempt){
        return attempt - 1;
    }

    private List<String> getFinalWinner(RacingCarList racingCarList, int length) {
        int maxDistance = ZERO;
        List<String> winners = new ArrayList<>();
        for (int carIndex = 0; carIndex < length; carIndex++) {
            RacingCar car = racingCarList.getCar(carIndex);
            int carDistance = car.getDistance();

            if (carDistance > maxDistance) {
                winners.clear();
                maxDistance = carDistance;
            }
            if (car.getDistance() == maxDistance) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
