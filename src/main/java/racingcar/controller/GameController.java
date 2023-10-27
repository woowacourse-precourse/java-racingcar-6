package racingcar.controller;

import racingcar.domain.Circuit;
import racingcar.domain.TryCount;
import racingcar.dto.RacingResult;
import racingcar.dto.Winners;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.IntStream;

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
        Circuit circuit = setupRace();
        runRace(circuit);
        announceRaceWinners(circuit);
    }

    private Circuit setupRace() {
        return inputView.getInputCarNames();
    }

    private void runRace(Circuit circuit) {
        TryCount tryCount = inputView.getTryCount();
        IntStream.range(0, tryCount.getCount())
                .forEach(round -> raceOneRound(circuit));
    }

    private void raceOneRound(Circuit circuit) {
        List<RacingResult> raceResults = racingService.race(circuit);
        outputView.printRacingResult(raceResults);
    }

    private void announceRaceWinners(Circuit circuit) {
        Winners winners = racingService.announceWinners(circuit);
        outputView.printWinner(winners);
    }

}
