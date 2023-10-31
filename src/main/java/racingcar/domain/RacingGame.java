package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.power.DefaultPowerGenerator;
import racingcar.dto.GameResultDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final Referee referee;

    public RacingGame(InputView inputView, OutputView outputView, Referee referee) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.referee = referee;
    }

    public void run() {
        List<String> carNames = readCarNames();
        List<Car> participants = prepareRacingCars(carNames);
        RoundCount roundCount = readRaceRoundCount();
        outputView.showExecutedMessage();
        executeWholeRounds(participants, roundCount);
        outputView.showRoundResult(participants);
        GameResultDto gameResult = referee.publishGameResult(participants);
        outputView.showGameResult(gameResult);
    }

    private void executeWholeRounds(List<Car> participants, RoundCount roundCount) {
        while (roundCount.hasNextRound()) {
            executeRound(participants);
            roundCount.consumeRound();
        }
    }

    private void executeRound(List<Car> cars) {
        cars.forEach(Car::tryDrive);
    }

    private RoundCount readRaceRoundCount() {
        return inputView.readNumberOfRounds();
    }

    private List<Car> prepareRacingCars(List<String> carNames) {
        return carNames.stream()
                .map(carName -> new Car(carName, 0, new DefaultPowerGenerator()))
                .collect(Collectors.toList());
    }

    private List<String> readCarNames() {
        return inputView.readCarNames();
    }
}
