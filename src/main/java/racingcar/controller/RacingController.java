package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.service.RacingService;
import racingcar.view.ConsoleOutput;
import racingcar.view.InputView;

public class RacingController {
    private final InputView inputView;
    private final RacingService racingService;

    public RacingController(InputView inputView, RacingService racingService) {
        this.inputView = inputView;
        this.racingService = racingService;
    }

    public void run() {
        ConsoleOutput.displayMessage(ConsoleOutput.CAR_NAME_MESSAGE);
        String input = inputView.getCarNames();
        List<String> carNames = racingService.stringToList(input);
        racingService.isLengthGreaterThanFive(carNames);

        ConsoleOutput.displayMessage(ConsoleOutput.TRY_MESSAGE);
        int tries = inputView.getTries();
        racingService.isGreaterThanZero(tries);

        List<Car> carList = new ArrayList<>();
        Cars cars = new Cars(carNames);
    }
}
