package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.validator.CarValidator;
import racingcar.validator.RoundValidator;
import racingcar.view.GameView;

public class GameController {

    private int rounds;
    private Game game;
    private final GameView gameView;

    public GameController(GameView gameView) {
        this.gameView = gameView;
    }

    public void playGame() {
        setupGame();

        gameView.displayResultMessage();
        playRounds();

        gameView.displayFinalWinner(game.getWinnerNames());
    }

    private void setupGame() {
        gameView.displayStartGame();

        this.game = new Game(setupParticipantCars());

        this.rounds = setupRounds();
    }

    private static int setupRounds() {
        GameView.displayAskRounds();

        String rounds = Console.readLine();
        RoundValidator.validateRounds(rounds);
        return Integer.parseInt(rounds);
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

    private void playRounds() {
        for (int i = 0; i < rounds; i++) {
            game.moveCar();

            gameView.displayCurrentCarPosition(game.getCurrentParticipantCarPosition());
        }
    }
}