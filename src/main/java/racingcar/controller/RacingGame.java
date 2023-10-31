package racingcar.controller;

import java.util.List;
import racingcar.domain.car.Cars;
import racingcar.domain.car.CarsGenerator;
import racingcar.domain.messenger.Messenger;
import racingcar.domain.round.Round;
import racingcar.domain.car.strategy.CarMovementStrategy;
import racingcar.domain.car.strategy.MoveForwardOnceRandomlyStrategy;
import racingcar.dto.CarNamesDto;
import racingcar.dto.CarsInformationDto;
import racingcar.utility.Convertor;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame implements Game {

    private final InputView inputView;
    private final OutputView outputView;

    private final Messenger messenger = new Messenger();

    private final CarMovementStrategy carMovementStrategy = new MoveForwardOnceRandomlyStrategy();
    private final CarsGenerator carsGenerator = new CarsGenerator(carMovementStrategy);

    private Round round;
    private Cars cars;

    public RacingGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void run() {
        printRequestCarNamesMessage();
        inputCars();
        printRequestRoundCountMessage();
        inputRound();
        printPlayResultMessage();
        while (round.hasMoreRounds()) {
            cars.move();
            printRoundResult();
            round.nextRound();
        }
        printWinners();
    }

    private void printRequestCarNamesMessage() {
        String requestCarNamesMessage = messenger.getRequestCarNames();
        outputView.print(requestCarNamesMessage);
    }

    private void inputCars() {
        String namesString = inputView.input();
        List<String> names = Convertor.split(namesString, Messenger.CAR_NAMES_DELIMITER);
        cars = carsGenerator.generateCarsFromNames(names);
    }

    private void printRequestRoundCountMessage() {
        String requestRoundCountMessage = messenger.getRequestRoundCount();
        outputView.print(requestRoundCountMessage);
    }

    private void inputRound() {
        String roundCountString = inputView.input();
        int roundCount = Convertor.parseInt(roundCountString);
        round = new Round(roundCount);
    }

    private void printPlayResultMessage() {
        String playResultMessage = messenger.getPlayResultMessage();
        outputView.print(playResultMessage);
    }

    private void printRoundResult() {
        CarsInformationDto carsInformationDto = cars.getInformation();
        String roundResult = messenger.getRoundResult(carsInformationDto);
        outputView.print(roundResult);
    }

    private void printWinners() {
        CarNamesDto winnerNamesDto = cars.findWinnerNames();
        String winnersMessage = messenger.getWinners(winnerNamesDto);
        outputView.print(winnersMessage);
    }

}