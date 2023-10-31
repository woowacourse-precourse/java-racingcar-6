package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.repository.CarRepository;
import racingcar.service.GameService;
import racingcar.util.ExtractElementUtil;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TrialNumberValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;


import java.util.List;

public class RacingController {

    private static final GameService gameService = new GameService();
    private static final ExtractElementUtil extractElementUtil = new ExtractElementUtil();
    private static final CarRepository carRepository = new CarRepository();

    public void racingCar() {
        saveCars(extractElementUtil.extractCarNames(getCarNamesInput()));
        playGame(startGame());
    }

    private String getCarNamesInput() {
        InputView.requestCarNames();
        return checkValidationCarNames(Console.readLine());
    }

    private String checkValidationCarNames(String input) throws IllegalArgumentException {
        CarNameValidator.checkCarNamesInput(input);
        return input;
    }

    private void saveCars(List<String> carNames) {
        for (String carName : carNames) {
            carRepository.save(new Car(carName));
        }
    }

    private Game startGame() {
        Game game = new Game(getCarList(), getTrialNumber());
        gameService.save(game);
        return game;
    }

    private void playGame(Game game) {
        OutputView.showHead();
        while (!gameService.isEnd(game)) {
            gameService.play(game);
            OutputView.showScores(game.getCars());
        }
        OutputView.showWinners(gameService.getWinners(game));
    }

    private int getTrialNumber() {
        return extractElementUtil.extractTrialNumber(getTrialNumberInput());
    }

    private String getTrialNumberInput() {
        InputView.requestTrialNumber();
        return checkValidationTrialNumber(Console.readLine());
    }

    private String checkValidationTrialNumber(String input) throws IllegalArgumentException {
        TrialNumberValidator.checkTrialNumberInput(input);
        return input;
    }

    private List<Car> getCarList() {
        return carRepository.findAll();
    }

}
