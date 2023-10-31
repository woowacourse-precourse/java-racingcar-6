package racingcar.controller;

import java.util.List;

import racingcar.domain.GameCondition;
import racingcar.view.Player;
import racingcar.view.PrintMessage;

public class RacingcarController {
    private Player player;
    private PrintMessage printMessage;

	public RacingcarController() {
        this.player = new Player();
        this.printMessage = new PrintMessage();
    }

    public void run() {
        GameCondition gameCondition = setRacing();
        int movingTrial = player.movingNumber();
        printMessage.printNotice();
        raceWithHistory(movingTrial, gameCondition);
        printMessage.printWinner(gameCondition.racing().findWinners());
    }

    private GameCondition setRacing() {
        List<String> carNames = player.promptCarNames();
        return new GameCondition(carNames);
    }

    private void raceWithHistory(int movingTrial, GameCondition gameCondition) {
        for (int i = 0; i < movingTrial; i++) {
            gameCondition.race();

            printMessage.printRacingResult(gameCondition
                    .racing()
                    .getScore());
        }
    }
}