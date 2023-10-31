package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        String[] carNames = inputHandler.getCarNamesFromUser();
        int raceCount = inputHandler.getRaceCountFromUser();

        RacingGame racingGame = new RacingGame(List.of(carNames), raceCount);
        racingGame.start();
        racingGame.printWinners();
    }
}

