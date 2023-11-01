package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.util.StringParser;
import racingcar.view.ConsoleScanner;

public class RacingGame {
    private Cars cars;
    private Integer round;

    public RacingGame() {
    }

    public void initiate() {
        initiateCars();
        initiateRound();
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
}
