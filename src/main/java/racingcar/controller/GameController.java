package racingcar.controller;

import racingcar.domain.RacingCarGame;
import racingcar.util.InputUtil;
import racingcar.util.OutputUtil;

public class GameController implements RacingCarGame {

    private GameController() {}

    public static void start() {
        OutputUtil.println(RacingCarGame.GAME_START_MESSAGE);
        String carNames = InputUtil.stringInput();
        OutputUtil.println(RacingCarGame.ASK_GAME_COUNT_MESSAGE);
        OutputUtil.print(RacingCarGame.VIEW_WINNER_MESSAGE + RacingCarGame.play(carNames, inputCoin()));
    }

    private static int inputCoin() {
        return InputUtil.covertInteger(InputUtil.stringInput());
    }
}
