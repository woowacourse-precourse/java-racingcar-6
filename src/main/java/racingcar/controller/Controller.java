package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.utils.Parser;
import racingcar.utils.RandomGenerator;
import racingcar.utils.Validator;
import racingcar.view.InputView;

import java.util.List;
import java.util.stream.Collectors;

public class Controller {

    private final Validator validator = new Validator();
    private final Parser parser = new Parser();
    private Game game;


    private List<Car> getCars() {
        InputView.printCarNameRequest();
        return getCarNameList().stream()
                .map(carName -> new Car(carName, new RandomGenerator()))
                .collect(Collectors.toList());
    }

    private List<String> getCarNameList() {
        return parseCarNameInput(checkValidationCarNameInput(Console.readLine()));
    }

    private List<String> parseCarNameInput(String userInput) {
        return parser.parseCarNameInput(userInput);
    }

    private String checkValidationCarNameInput(String userInput) {
        return validator.validateCarNameInput(userInput);
    }

    private int getAttemptCount() {
        InputView.printAttemptCountRequest();
        return ParseAttemptCountInput(CheckValidationAttemptCountInput(Console.readLine()));
    }

    private int ParseAttemptCountInput(String userInput) {
        return parser.parseAttemptCountInput(userInput);
    }

    private String CheckValidationAttemptCountInput(String userInput) {
        return validator.validateAttemptCountInput(userInput);
    }

}
