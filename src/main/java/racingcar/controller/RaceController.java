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
        int count = initializeCount();
    }

    private int initializeCount() {
        outputView.countOutput();
        String countInput = inputView.getCountInput();
        return raceService.initializeCount(countInput);
    }

    private Cars initializeCars() {
        outputView.carNamesOutput();
        List<String> carNamesInput = inputView.getCarNamesInput();
        return raceService.initializeCars(carNamesInput);
    }
}
