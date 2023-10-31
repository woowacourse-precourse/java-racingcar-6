package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Cars;
import racingcar.domain.Game;
import racingcar.service.GameService;
import racingcar.view.ConsoleView;
import racingcar.view.GameView;

public class GameController {
    private static final String CAR_NAME_DELIMITER = ",";
    private static final int MIN_MOVE_COUNT = 1;
    private static final int MAX_MOVE_COUNT = 10;
    private static final String MOVE_COUNT_RANGE_ERROR_MESSAGE = "이동 횟수는 10 이하의 자연수여야 함";

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
        int userInput = Integer.valueOf(gameView.getUserInput());
        if (!validateMoveCount(userInput)) {
            throw new IllegalArgumentException(MOVE_COUNT_RANGE_ERROR_MESSAGE);
        }
        return userInput;
    }

    private boolean validateMoveCount(int count) {
        return count >= MIN_MOVE_COUNT && count <= MAX_MOVE_COUNT;
    }


    private void playRound(int count) {
        gameView.printExecutionStart();
        for (int i = 0; i < count; i++) {
            cars.updateAllDistance();
            List<Car> roundResult = getRoundResult();
            gameView.printMoveResult(roundResult);
        }
    }

    private List<Car> getRoundResult() {
        return cars.getCars();
    }

    private void endGame() {
        List<String> winners = cars.findWinners();
        gameView.printFinalWinner(winners);
    }

}
