package racingcar.controller;

import racingcar.dto.CarDto;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.NumberGenerator;
import racingcar.model.RandomNumberGenerator;
import racingcar.model.Round;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;



public class RacingGameController {

    private static final int MOVE_THRESHOLD = 4;

    private final NumberGenerator numberGenerator;

    public RacingGameController() {
         this.numberGenerator = new RandomNumberGenerator();
    }

    public void gameStart() {

        Cars players = participatePlayers();

        Round round = askRoundCount();

        race(players, round);

        awardRacingCarGame(players);
    }

    private Cars participatePlayers() {
        List<Car> cars = InputView.inputNames().stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    private Round askRoundCount() {
        return new Round(InputView.inputRound());
    }

    private void race(Cars players, Round round) {
        OutputView.printResultMessage();

        do {
            playRound(players);
            round.finishCurrentRound();
        } while (round.hasRemainingRound());
    }

    private void playRound(Cars players) {
        players.moveUsingRandomNumber(numberGenerator,
                randomNumber -> randomNumber.isGreaterThan(MOVE_THRESHOLD)
        );
        printRoundResult(players);
    }

    private void printRoundResult(Cars players) {
        OutputView.printRoundResult(players.toDtos());
        OutputView.printBlankLine();
    }

    private void awardRacingCarGame(Cars players) {
        List<CarDto> winners = players.findWinner().stream()
                .map(Car::toDto)
                .collect(Collectors.toList());

        OutputView.printWinner(winners);
    }
}
