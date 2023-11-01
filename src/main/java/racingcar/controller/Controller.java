package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.utils.Parser;
import racingcar.utils.RandomGenerator;
import racingcar.utils.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;


public class Controller {

    private final Validator validator = new Validator();
    private final Parser parser = new Parser();
    private Game game;

    public void run() {
        game = new Game(getCars(), getAttemptCount());

        while (!game.isGameOver()) {
            game.carRaceOnce();
            OutputView.printRaceStatus(game.getCars());
        }

        OutputView.printWinnerName(game.getWinners());
    }

    private List<Car> getCars() {
        OutputView.printCarNameRequest();
        return createCars();
    }

    private List<Car> createCars() {
        List<Car> cars = new ArrayList<>();
        for(String carName : getCarsName()){
            cars.add(new Car(carName, new RandomGenerator()));
        }
        return cars;
    }

    private List<String> getCarsName() {
        return parseCarNameInput(checkValidationCarNameInput(InputView.takeUserInput()));
    }

    private List<String> parseCarNameInput(String userInput) {
        return parser.parseCarNameInput(userInput);
    }

    private String checkValidationCarNameInput(String userInput) {
        return validator.validateCarNameInput(userInput);
    }

    private int getAttemptCount() {
        OutputView.printAttemptCountRequest();
        return ParseAttemptCountInput(CheckValidationAttemptCountInput(InputView.takeUserInput()));
    }

    private int ParseAttemptCountInput(String userInput) {
        return parser.parseAttemptCountInput(userInput);
    }

    private String CheckValidationAttemptCountInput(String userInput) {
        return validator.validateAttemptCountInput(userInput);
    }



}

