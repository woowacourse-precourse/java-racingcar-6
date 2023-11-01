package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.service.GameService;
import racingcar.util.Parser;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private Map<Car, List<Integer>> positionHistory = new HashMap<>();
    private final Validator validator = new Validator();
    private final Parser parser = new Parser();
    private final GameService gameService = new GameService();

    public void run() {
        saveCars(parser.parseCarNames(getCarNamesByUserInput()));
        play(createGame());
    }

    private Game createGame() {
        Game game = new Game(getCars(), getNumberOfTrial());
        return game;
    }

    private void play(Game game) {
        OutputView.printHead();
        gameService.play(game);
    }

    Map<Car, List<Integer>> getPositionHistory() {
        return positionHistory;
    }

    private List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        for (Car car : positionHistory.keySet()) {
            cars.add(car);
        }
        return cars;
    }

    private int getNumberOfTrial() {
        return parser.parseNumberOfTrial(getTrialByUserInput());
    }

    private void saveCars(List<String> carNames) {
        for (String carName : carNames) {
            positionHistory.put(new Car(carName), new ArrayList<>());
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
