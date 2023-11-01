package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Cars;
import racingcar.domain.Game;
import racingcar.domain.dto.CarDto;
import racingcar.service.GameService;
import racingcar.view.ConsoleView;
import racingcar.view.GameView;

public class GameController {
    private static final String CAR_NAME_DELIMITER = ",";


    private final GameView gameView;
    private final GameService gameService;

    public GameController() {
        this.gameView = new ConsoleView();
        this.gameService = new GameService();
    }

    public void startGame() {
        gameView.printInputCars();
        List<String> carNames = getCarNamesFromUser();
        Cars cars = Cars.createNewCars(carNames);

        gameView.printInputMoveCount();
        int roundCount = getRoundCountFromUser();
        Game game = Game.createNewGame(roundCount);

        printRoundResult(cars, game);
        printWinners(cars);
    }

    private List<String> getCarNamesFromUser() {
        return Arrays.stream(gameView.getUserInput().split(CAR_NAME_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private int getRoundCountFromUser() {
        return Integer.valueOf(gameView.getUserInput());
    }
    
    private void printRoundResult(Cars cars, Game game) {
        gameView.printExecutionStart();

        while (!game.isGameEnd()) {
            List<CarDto> roundResult = gameService.getRoundResult(cars, game);
            gameView.printMoveResult(roundResult);
        }
    }

    private void printWinners(Cars cars) {
        List<String> winners = cars.findWinners();
        gameView.printFinalWinner(winners);
    }

}
