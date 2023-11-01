package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.repository.CarRepository;
import racingcar.service.GameService;
import racingcar.util.Parser;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Controller {

    // service, util, repository, view 등의 인스턴스 초기화
    private final GameService gameService = new GameService();
    private final Parser parser = new Parser();
    private final Validator validator = new Validator();
    private final CarRepository carRepository = new CarRepository();

    // 게임 실행
    public void run() {
        saveCars(parser.parseCarNames(getCarNamesByUserInput()));
        playGame(createGame());
    }

    private Game createGame() {
        Game game = new Game(getCarList(), getNumberOfTrials());
        gameService.saveGame(game);
        return game;
    }

    private void playGame(Game game) {
        OutputView.printHeader();
        while(!gameService.isGameFinished(game)) {
            gameService.playRound(game);
            OutputView.printCarScores(game.getCars());
        }
        OutputView.printWinners(gameService.getWinners(game));
    }

    private int getNumberOfTrials() {
        return parser.parseNumberOfTrials(getTrialByUserInput());
    }

    private String getTrialByUserInput() {
        InputView.requestNumberOfTrialsInput();
        return checkValidationNumberOfTrialsInput(Console.readLine());
    }

    private String checkValidationNumberOfTrialsInput(String input) {
        try {
            validator.validateNumberOfTrialsInput(input);
            return input;
        } catch (IllegalArgumentException e) {
            OutputView.printException(e.getMessage());
            return getTrialByUserInput();
        }
    }

    private List<Car> getCarList() {
        return carRepository.findAllCars();
    }

    private void saveCars(List<String> carNames) {
        for (String carName : carNames) {
            carRepository.save(new Car(carName));
        }
    }

    private String getCarNamesByUserInput() {
        InputView.requestCarNamesInput();
        String input = Console.readLine();
        return checkValidationCarNamesInput(input);
    }

    private String checkValidationCarNamesInput(String input) {
        try {
            validator.validateCarNamesInput(input);
            return input;
        } catch (IllegalArgumentException e) {
            OutputView.printException(e.getMessage());
            return getCarNamesByUserInput();
        }
    }
}