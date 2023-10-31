package controller;

import camp.nextstep.edu.missionutils.Console;

import domain.Car;
import domain.Game;
import repository.CarRepository;
import service.GameService;
import util.Parser;
import util.Validator;
import view.InputView;
import view.OutputView;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Controller {

    private final GameService gameService = new GameService();
    private final Parser parser = new Parser();
    private final Validator validator = new Validator();
    private CarRepository carRepository = new CarRepository();

    public void run() {
        saveCarNames(parser.parseCarNames(getCarNamesInput()));
        play(playGame());
    }

    private Game playGame() {
        Game game = new Game(getCarList(), getTrialNumber());
        gameService.save(game);
        return game;
    }

    private void play(Game game) {
        OutputView.printPlayResult();
        while (!gameService.isEnd(game)) {
            gameService.play(game);
            OutputView.printState(game.getCarList());
        }
        OutputView.printWinner(gameService.getWinner(game));
    }

    private void saveCarNames(List<String> carNames) {
        for (String carName : carNames) {
            carRepository.save(new Car(carName));
        }
    }

    private String getCarNamesInput() {
        InputView.requestCarNames();
        String input = readLine();

        return checkAllValidationOfCar(input);
    }

    private String checkAllValidationOfCar(String input) {
        validator.checkCarNamesInput(input, parser.parseCarNames(input));
        return input;
    }

    private List<Car> getCarList() {
        return carRepository.findAll();
    }

    private int getTrialNumber() {
        return parser.parseTrialNumber(getTrialNumberByInput());
    }

    private String getTrialNumberByInput() {
        InputView.requestNumberOfGames();
        return checkAllValidationOfTrial(readLine());
    }

    private String checkAllValidationOfTrial(String input) {
        validator.checkTrialNumberInput(input);
        return input;
    }

}
