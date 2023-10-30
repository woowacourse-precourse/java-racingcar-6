package racingcar.domain;

import racingcar.dto.CarDTO;

import java.util.ArrayList;
import java.util.Map;

public class CarGame {

    private final Cars cars;
    private final CarGameRound gameRound;

    private CarGame(Cars cars, CarGameRound gameRound) {
        this.cars = cars;
        this.gameRound = gameRound;
    }

    public static CarGame create(Cars cars, CarGameRound gameRound) {
        return new CarGame(cars, gameRound);
    }

    public CarDTO.ProgressResult race() {
        CarDTO.ProgressResult progressResult = new CarDTO.ProgressResult(new ArrayList<>());

        for (int i = 0; gameRound.isRunning(i); i++) {
            Map<String, Integer> status = cars.goForward();
            progressResult.addResult(status);
        }

        return progressResult;
    }

    public CarDTO.WinnerNames getWinner() {
        return new CarDTO.WinnerNames(cars.getWinningCarNames());
    }
}
