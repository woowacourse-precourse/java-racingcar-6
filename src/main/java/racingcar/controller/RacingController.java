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
        String names = getCarNames();
        int numberOfRace = getNumberOfRace();
        List<String> nameList = Parser.carNameParser(names);

        racingService.prepareRace(nameList, numberOfRace);
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

    private String getCarNames() {
        outputView.requestCarNamesMessage();
        return inputView.inputCarNamesToRace();
    }

    private int getNumberOfRace() {
        outputView.requestNumberOfTryMessage();
        return Integer.parseInt(inputView.inputNumberOfRace());
    }

    private void raceResult() {
        outputView.raceWinnerMessage(racingService.getWinner());
    }
}
