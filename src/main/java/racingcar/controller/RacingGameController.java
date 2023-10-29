package racingcar.controller;

import racingcar.dto.CarDto;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.NumberGenerator;
import racingcar.model.RandomNumberGenerator;
import racingcar.model.TrialCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;



public class RacingGameController {

    private final NumberGenerator numberGenerator;

    public RacingGameController() {
         this.numberGenerator = new RandomNumberGenerator();
    }

    public void gameStart() {

        Cars players = participatePlayers();

        TrialCount trialCount = inputTrialCount();

        race(players, trialCount);

        awardRacingCarGame(players);
    }

    private TrialCount inputTrialCount() {
        return new TrialCount(InputView.inputTrialCount());
    }

    private Cars participatePlayers() {
        List<Car> cars = InputView.inputNames().stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    private void race(Cars players, TrialCount trialCount) {
        OutputView.printResultMessage();

        while (trialCount.hasCount()) {
            players.moveUsingRandomNumber(numberGenerator);
            OutputView.printRoundResult(players.toDtos());
            OutputView.printBlank();

            trialCount.countDown();
        }
    }

    private void awardRacingCarGame(Cars players) {
        List<CarDto> winners = players.findWinner().stream()
                .map(Car::toDto)
                .collect(Collectors.toList());

        OutputView.printWinner(winners);
    }
}
