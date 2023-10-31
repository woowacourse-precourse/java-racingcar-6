package racingcar.presentation;

import racingcar.application.RaceService;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private static final String CAR_NAME_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final OutputView outputView;
    private final InputView inputView;
    private final RaceService raceService;

    public RaceController(OutputView outputView, InputView inputView, RaceService raceService) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.raceService = raceService;
    }

    public void startRace() {
        outputView.printlnMessage(CAR_NAME_REQUEST_MESSAGE);
        Cars cars = raceService.generateCars(inputView.readCarNames());
        Integer count = raceService.generateCount(inputView.readInput());
    }
}
