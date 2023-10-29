package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RaceService raceService;

    public RaceController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.raceService = new RaceService();
    }

    public void run() {
        Cars cars = initializeCars();

    }

    private Cars initializeCars() {
        outputView.carNamesOutput();
        List<String> carNamesInput = inputView.carNamesInput();
        return raceService.initializeCars(carNamesInput);
    }
}
