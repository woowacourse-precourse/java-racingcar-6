package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.controller.RacingGame;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;
import static camp.nextstep.edu.missionutils.Randoms.*;

public class Application {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.gameStart();
        racingGame.executionResult();
        racingGame.finalWinner();
    }
}
