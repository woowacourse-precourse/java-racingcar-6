package racingcar.controller;

import racingcar.domain.Circuit;
import racingcar.domain.TryCount;
import racingcar.dto.RacingResult;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingService racingService;

    public GameController(InputView inputView, OutputView outputView, RacingService racingService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingService = racingService;
    }

    public void playGame() {
        Circuit circuit = inputView.getInputCarNames();
        TryCount tryCount = inputView.getTryCount();
        for (int i = 0; i < tryCount.getCount(); i++) {
            List<RacingResult> raceResults = racingService.race(circuit);
            outputView.printRacingResult(raceResults);
        }
        outputView.printWinner(circuit.getWinners());

    }
}
