package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.utils.Parser;
import racingcar.utils.RandomGenerator;
import racingcar.utils.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

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

        OutputView.printWinnerName(game.getWinner());
    }

    private List<Car> getCars() {
        OutputView.printCarNameRequest();
        return getCarNameList().stream()
                .map(carName -> new Car(carName, new RandomGenerator()))
                .collect(Collectors.toList());
    }

    private List<String> getCarNameList() {
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
