package racingcar.console.game.racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.console.game.Game;
import racingcar.console.game.racingcar.car.Car;
import racingcar.console.game.racingcar.constants.GameMessages;
import racingcar.console.game.racingcar.core.GameManager;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame implements Game {

    private final GameManager gameManager;

    public RacingCarGame() {
        gameManager = new GameManager();
    }

    @Override
    public void start() {
        readyToRace();
        startRace();
        determineWinners();
        announceWinners();
    }

    private void readyToRace() {
        System.out.println(GameMessages.REQUEST_CAR_LIST);
        gameManager.registerCarList(Console.readLine());

        System.out.println(GameMessages.REQUEST_TOTAL_ROUND);
        gameManager.setTotalRound(Console.readLine());
    }

    private void startRace() {
        System.out.println(GameMessages.ROUND_RESULT);
        gameManager.startRace();
    }

    private void determineWinners() {
        gameManager.calculateWinners();
    }

    private void announceWinners() {
        System.out.print(GameMessages.TOTAL_WINNER);
        System.out.println(gameManager.getWinners());
    }
}
