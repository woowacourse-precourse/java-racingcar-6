package racingcar.controller;

import java.util.List;
import racingcar.dto.Progress;
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
        int tryCount = setupRace();
        raceWholeRound(tryCount);
        printFinalWinner();
    }

    private int setupRace() {
        inputView.printAskName();

        List<String> carNames = inputView.getCarNames();
        raceService.init(carNames);

        inputView.printAskCount();
        return inputView.getTryCount();
    }


    private void raceWholeRound(int tryCount) {
        outputView.printResultHeader();
        while (tryCount-- > 0) {
            List<Progress> progressList = raceService.moveCar();
            outputView.printProgress(progressList);
        }
    }

    private void printFinalWinner() {
        List<String> winners = raceService.getWinner();
        outputView.printWinners(winners);
    }
}
