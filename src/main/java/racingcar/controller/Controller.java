package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.util.Parser;
import racingcar.util.Exception;
import racingcar.repository.CarRepository;

import java.util.List;

public class Controller {

    private final GameService gameService = new GameService();
    private final Parser parser = new Parser();
    private final Exception exception = new Exception();
    private final CarRepository carRepository = new CarRepository();

    public void run() {
        saveCars(parser.parseCarNames(getCarNameByUserInput()));
        play(createGame());
    }

    private Game createGame() {
        Game game = new Game(getCarList(),getNumberOfPlayCount());
        gameService.save(game);
        return game;
    }

    private int getNumberOfPlayCount() {
        return parser.parseNumberOfPlaycount(getPlayCountByUserInput());
    }

    private void play(Game game) {
        OutputView.printHead();
        while (!gameService.isEnd(game)) {
            gameService.Movingstart(game);
            OutputView.printScore(game.getCars());
        }
        OutputView.printWinners(gameService.getWinners(game));
    }


    private List<Car> getCarList() {
        return carRepository.findAll();
    }

    private void saveCars(List<String> carNames) {
        for (String carName : carNames) {
            carRepository.save(new Car(carName));
        }
    }

    private String getCarNameByUserInput(){
        InputView.requestCarNamesMessage();
        String input = Console.readLine();
        return checkValidateCarName(input);
    }

    private String getPlayCountByUserInput() {
        InputView.requestNumberOfPlayCountMessage();
        return checkValidationNumberOfPlayCount(Console.readLine());
    }

    private String checkValidateCarName(String input) {
        try {
            exception.checkCarNamesInput(input);
            return input;
        } catch (IllegalArgumentException e) {
            OutputView.printException(e.getMessage());
            return getCarNameByUserInput();
        }
    }

    private String checkValidationNumberOfPlayCount(String input) {
        try {
            exception.checkNumberOfPlayCountInput(input);
            return input;
        } catch (IllegalArgumentException e) {
            OutputView.printException(e.getMessage());
            return getPlayCountByUserInput();
        }
    }
}
