package racingcar.controller;

import java.util.List;
import racingcar.service.CarDto;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final RacingService racingService;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(final RacingService racingService, final InputView inputView,
                            final OutputView outputView) {
        this.racingService = racingService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<String> carNames = getCarNameList();
        int numberOfRace = getNumberOfRace();

        racingService.prepareRace(carNames, numberOfRace);
        runRace();
        raceResult();
    }

    public void runRace() {
        outputView.raceResultMessage();

        while (racingService.isRunning()) {
            List<CarDto> result = racingService.runSingleRace();
            outputView.raceResultByOrderMessage(result);
        }
    }

    private List<String> getCarNameList() {
        outputView.requestCarNamesMessage();
        String carNames = inputView.inputCarNamesToRace();

        List<String> nameList = Parser.carNameParser(carNames);

        return nameList;
    }

    private int getNumberOfRace() {
        outputView.requestNumberOfTryMessage();
        String numberOfRace = inputView.inputNumberOfRace();

        Validator.inputNumberValidator(numberOfRace);

        return Integer.parseInt(numberOfRace);
    }

    private void raceResult() {
        outputView.raceWinnerMessage(racingService.getWinner());
    }
}
