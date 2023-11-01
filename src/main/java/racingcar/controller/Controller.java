package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.service.GameService;
import racingcar.util.Parser;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private final List<Car> cars = new ArrayList<>();
    private final Validator validator = new Validator();
    private final Parser parser = new Parser();
    private final GameService gameService = new GameService();

    public void run() throws IllegalArgumentException {
        saveCars(parser.parseCarNames(getCarNamesByUserInput()));
        play(createGame());
    }

    private Game createGame() {
        return new Game(getCars(), getNumberOfTrial());
    }

    private void play(Game game) {
        OutputView.printHead();
        gameService.play(game);
        OutputView.showScore(game.getCars());
        OutputView.showWinners(gameService.findWinners(game));
    }

    private List<Car> getCars() {
        return cars;
    }

    private int getNumberOfTrial() throws IllegalArgumentException {
        return parser.parseNumberOfTrial(getTrialByUserInput());
    }

    private void saveCars(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    private String getCarNamesByUserInput() throws IllegalArgumentException {
        InputView.requestCarNamesMessage();
        String input = Console.readLine();
        validator.checkCarNamesInput(input);
        return input;
    }

    private String getTrialByUserInput() throws IllegalArgumentException {
        InputView.requestNumberOfTrialMessage();
        String input = Console.readLine();
        validator.checkNumberOfTrialInput(input);
        return input;
    }
}
