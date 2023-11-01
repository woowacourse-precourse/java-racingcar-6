package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.repository.CarRepository;
import racingcar.repository.GameRepository;
import racingcar.service.GameService;
import racingcar.util.Checker;
import racingcar.util.Parser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {

    private final GameService gameService = new GameService();
    private final GameRepository gameRepository = new GameRepository();
    private final CarRepository carRepository = new CarRepository();
    private final Parser parser = new Parser();
    private final Checker checker = new Checker();

    public void runGame() {
        saveCars(parser.parseCarNames(getCarNamesByUserInput()));
        playGame(startGame());
    }

    private Game startGame() {
        Game game = new Game(getCarNameList(), getMoveCount());
        gameService.saveGame(game);
        return game;
    }

    private int getMoveCount() {
        InputView.inputCountMessage();
        String moveCount = Console.readLine();
        return Integer.parseInt(moveCount);
    }

    private List<Car> getCarNameList() {
        return carRepository.findAll();
    }

    private void playGame(Game game) {
        OutputView.outputMessage();
        while (!gameService.isGameEnd((game))) {
            gameService.playGame(game);
            OutputView.outputResult(game.getCars());
        }
        OutputView.outputWinners(gameService.getWinners(game));
    }

    private String getCarNamesByUserInput() {
        InputView.inputNameMessage();
        String input = Console.readLine();
        return checkCarNameInput(input);

    }

    private String checkCarNameInput(String input) {
        try {
            checker.checkCarNamesInput(input);
            return input;
        } catch (IllegalArgumentException e) {
            return getCarNamesByUserInput();
        }
    }

    private void saveCars(List<String> carNames) {
        for (String carName : carNames) {
            carRepository.save(new Car(carName));
        }
    }
}
