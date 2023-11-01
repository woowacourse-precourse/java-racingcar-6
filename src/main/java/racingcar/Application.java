package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import racingcar.Service.InputHandler;
import racingcar.Service.OutputHandler;
import racingcar.Service.RacingGame;


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

