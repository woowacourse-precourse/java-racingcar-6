package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.util.StringParser;
import racingcar.view.ConsolePrinter;
import racingcar.view.ConsoleScanner;

public class RacingGame {
    private Cars cars;
    private Integer round;

    public void play() {
        initiate();

        ConsolePrinter.printResultMessage();
        while (round > 0) {
            cars.playOneRound();
            decreaseRound();
        }

        List<String> finalWinners = cars.getFinalWinners();
        ConsolePrinter.printFinalWinners(finalWinners);
    }

    private void initiate() {
        initiateCars();
        initiateRound();
        ConsolePrinter.printEmptyLine();
    }

    private void initiateCars() {
        String carNameInput = ConsoleScanner.readCarName();
        List<String> carNames = StringParser.parseCarName(carNameInput);
        this.cars = new Cars(carNames);
    }

    private void initiateRound() {
        String roundInput = ConsoleScanner.readRound();
        this.round = StringParser.parseRound(roundInput);
    }

    private void decreaseRound() {
        round--;
    }
}
