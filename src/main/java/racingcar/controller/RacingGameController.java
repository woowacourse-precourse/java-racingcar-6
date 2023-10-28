package racingcar.controller;

import static racingcar.view.InputView.inputNames;
import static racingcar.view.InputView.inputTrialCount;
import static racingcar.view.OutputView.printResultMessage;
import static racingcar.view.OutputView.printRoundResult;
import static racingcar.view.OutputView.printWinner;
import static racingcar.view.OutputView.printBlank;

import racingcar.dto.CarDto;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.NumberGenerator;
import racingcar.model.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;



public class RacingGameController {

    private final NumberGenerator numberGenerator;

    public RacingGameController() {
         this.numberGenerator = new RandomNumberGenerator();
    }

    public void gameStart() {

        List<Car> cars = inputNames().stream()
                .map(Car::new)
                .collect(Collectors.toList());
        Cars players = new Cars(cars);

        int trialCount = inputTrialCount();

        printResultMessage();
        for (int i = 0; i < trialCount; i++) {
            players.moveUsingRandomNumber(numberGenerator);
            printRoundResult(players.toDtos());
            printBlank();
        }

        List<CarDto> winners = players.findWinner().stream()
                .map(Car::toDto)
                .collect(Collectors.toList());

        printWinner(winners);
    }
}
