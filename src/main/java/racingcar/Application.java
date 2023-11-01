package racingcar;

import racingcar.service.InputHandler;
import racingcar.service.OutputHandler;
import racingcar.service.RacingGame;


import java.util.*;

public class Application {
    public static void main(String[] args) {

        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();

        String[] carNames = inputHandler.getCarNamesFromUser();
        int raceCount = inputHandler.getRaceCountFromUser();

        RacingGame racingGame = new RacingGame(List.of(carNames), raceCount, outputHandler);
        racingGame.start();
        racingGame.printWinners();
    }
}

