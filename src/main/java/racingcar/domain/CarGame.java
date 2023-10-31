package racingcar.domain;

import racingcar.presentation.CarDTO;
import racingcar.util.NumberGenerator;

import java.util.ArrayList;

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

    public CarDTO.ProgressResult race(NumberGenerator generator) {
        CarDTO.ProgressResult progressResult = new CarDTO.ProgressResult(new ArrayList<>());

        while (gameRound.isRunning()) {
            cars.moveAll(generator);
            progressResult.addResult(cars.getStatus());
            gameRound.nextRound();
        }

        return progressResult;
    }

    public CarDTO.WinnerNames getWinner() {
        return new CarDTO.WinnerNames(cars.findWinningCarNames());
    }
}
