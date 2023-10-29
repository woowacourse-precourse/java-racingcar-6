package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Circuit;
import racingcar.domain.TryCount;
import racingcar.dto.RacingResult;
import racingcar.dto.Winners;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;
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
        TryCount tryCount = TryCount.of(inputView.getTryCount());

        runRace(tryCount, circuit);
        announceRaceWinners(circuit);
    }

    private void runRace(TryCount tryCount, Circuit circuit) {
        outputView.printRoundHeader();
        IntStream.range(0, tryCount.getCount())
                .forEach(round -> raceOneRound(circuit));
    }

    private Circuit setupRace() {
        List<String> carNames = inputView.getInputCarNames();
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();
        return Circuit.fromCarNames(cars);
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
