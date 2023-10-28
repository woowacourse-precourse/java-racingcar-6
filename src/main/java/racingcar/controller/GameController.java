package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.validator.CarValidator;
import racingcar.validator.RacingCountValidator;
import racingcar.view.GameView;

public class GameController {

    private int retryCount;
    private Game game;
    private final GameView gameView;

    public GameController(GameView gameView) {
        this.gameView = gameView;
    }

    public void playGame() {
        setupGame();

        gameView.displayResultMessage();
        tryRoundUntilRetryCount();

        gameView.displayFinalWinner(game.getWinnerNames(game.getWinnerList()));
    }

    private void setupGame() {
        gameView.displayStartGame();

        this.game = new Game(setupParticipantCars());

        this.retryCount = setupRetryCount();
    }

    private static int setupRetryCount() {
        GameView.displayAskTryCount();

        String tryCount = Console.readLine();
        RacingCountValidator.validateRacingCount(tryCount);
        return Integer.parseInt(tryCount);
    }

    private static List<Car> setupParticipantCars() {
        String input = Console.readLine();

        CarValidator.validateNameUsingCommas(input);
        List<String> carNameList = List.of(input.split(","));

        return carNameList.stream()
            .peek(CarValidator::validateNameLength)
            .map(Car::new)
            .collect(Collectors.toList());
    }

    private void tryRoundUntilRetryCount() {
        for (int i = 0; i < retryCount; i++) {
            game.moveCar();

            gameView.displayCurrentCarPosition(game.getCurrentParticipantCarPosition());
        }
    }
}