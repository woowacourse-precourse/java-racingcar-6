package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.repository.CarRepository;
import racingcar.service.GameService;
import racingcar.util.Checker;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {
    private final GameService gameService = new GameService();
    private final Checker checker = new Checker();
    private final Validator validator = new Validator();
    private final CarRepository carRepository = new CarRepository();

    public void run() {
        saveCars(checker.checkCarNames(getCarNamesByUserInput()));
        play(createGame());
    }

    private Game createGame() {
        Game game = new Game(getCarList(),getNumberOfTrial());
        gameService.save(game);
        return game;
    }

    private void play(Game game) {
        OutputView.printHead();
        while (!gameService.isEnd(game)) {
                gameService.play(game);
                OutputView.printScore(game.getCars());
        }
        OutputView.printWinners(gameService.getWinners(game));

    }

    private int getNumberOfTrial() {
        return checker.checkNumberOfTrial(getTrialByUserInput());
    }

    private List<Car> getCarList() {
        return carRepository.findAll();
    }

    private void saveCars(List<String> carNames) {
        for (String carName : carNames) {
            carRepository.save(new Car(carName));
        }

    }

    private String getTrialByUserInput() {
        InputView.enterNumberOfTrialMessage();
        return checkValidationNumberOfTrialInput(Console.readLine());
    }

    private String checkValidationNumberOfTrialInput(String input) {
        try {
            validator.checkNumberOfTrialInput(input);
            return input;
        } catch (IllegalArgumentException e) {
            OutputView.printException(e.getMessage());
            return getTrialByUserInput();
        }
    }

    private String getCarNamesByUserInput() {
        InputView.enterCarNamesMessage();
        String input = Console.readLine();
        return checkValidationCarNamesInput(input);
    }

    private String checkValidationCarNamesInput(String input) {
        try {
            validator.checkCarNamesInput(input);
            return input;
        } catch (IllegalArgumentException e) {
            OutputView.printException(e.getMessage());
            return getCarNamesByUserInput();
        }
    }
}
