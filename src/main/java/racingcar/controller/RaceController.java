package racingcar.controller;

import java.util.List;
import racingcar.dto.Progress;
import racingcar.dto.Setup;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private final RaceService raceService;
    private final InputView inputView;
    private final OutputView outputView;

    public RaceController(RaceService raceService, InputView inputView, OutputView outputView) {
        this.raceService = raceService;
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void race() {
        Setup setup = setupRace();
        raceWholeRound(setup);
        printFinalWinner();
    }

    private Setup setupRace() {
        inputView.printAskName();
        List<String> carNames = inputView.getCarNames();

        inputView.printAskCount();
        int tryCount = inputView.getTryCount();
        return new Setup(tryCount, carNames);
    }


    private void raceWholeRound(Setup setup) {
        raceService.init(setup);
        outputView.printResultHeader();
        while (raceService.isRaceInProgress()) {
            List<Progress> progressList = raceService.moveCars();
            outputView.printProgress(progressList);
        }
    }

    private void printFinalWinner() {
        List<String> winners = raceService.getWinner();
        outputView.printWinners(winners);
    }
}
