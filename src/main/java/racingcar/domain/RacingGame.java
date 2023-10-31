package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.position.Position;
import racingcar.domain.power.DefaultPowerGenerator;
import racingcar.dto.GameResultDto;
import racingcar.dto.RoundResultDto;
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
        GameResultDto gameResult = referee.publishGameResult(participants);
        outputView.showGameResult(gameResult);
    }

    private void executeWholeRounds(List<Car> participants, RoundCount roundCount) {
        while (roundCount.hasNextRound()) {
            RoundResultDto roundResultDto = referee.executeRound(participants);
            outputView.showRoundResult(roundResultDto);
            roundCount.consumeRound();
        }
    }

    private RoundCount readRaceRoundCount() {
        return inputView.readNumberOfRounds();
    }

    private List<Car> prepareRacingCars(List<String> carNames) {
        return carNames.stream()
                .map(carName -> new Car(new CarName(carName), new Position(0), new DefaultPowerGenerator()))
                .collect(Collectors.toList());
    }

    private List<String> readCarNames() {
        return inputView.readCarNames();
    }
}
