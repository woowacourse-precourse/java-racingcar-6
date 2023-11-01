package racingcar.controller;

import racingcar.message.Message;
import racingcar.model.Car;
import racingcar.model.GameSetter;
import racingcar.model.RacingGame;
import racingcar.model.WinnerChecker;

import java.util.List;

public class GameController {

    public GameSetter gameSetter;
    public RacingGame racingGame;
    public WinnerChecker winnerChecker;

    public GameController() {
        this.gameSetter = new GameSetter();
        this.winnerChecker = new WinnerChecker();
        this.racingGame = new RacingGame();

    }

    public void runGame() {
        Message.getInstance().printPromptCarNames();
        List<Car> carList = gameSetter.inputCarName();

        Message.getInstance().printPromptNumberOfAttempts();
        int numberOfAccount = gameSetter.inputNumberOfAccount();

        Message.getInstance().printRaceResult();
        for (int i = 0; i < numberOfAccount; i++) {
            carList = racingGame.move(carList);
            Message.getInstance().printRace(carList);
        }

        List<String> winners = winnerChecker.checkWinner(carList);
        Message.getInstance().printWinner(winners);
    }

}