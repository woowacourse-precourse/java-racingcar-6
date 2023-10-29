package racingcar.controller;


import java.util.Arrays;
import java.util.List;

import racingcar.domain.Car;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;

public class RacingGameController {
    private final RacingCarService racingGameService;

    public RacingGameController() {
        this.racingGameService = new RacingCarService();
    }

    public void playRacingGame() {
        String input = InputView.inputCarsName();
        List<String> cars = Arrays.asList(input.split(","));
        List<Car> carList = racingGameService.participateCar(cars);

        int moveCount = InputView.inputMovesCount();
        while (moveCount-- > 0) {
            RacingCarService.moveCar();
        }

    }
}
