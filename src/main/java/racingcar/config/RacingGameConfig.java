package racingcar.config;

import racingcar.util.GameResultMaker;
import racingcar.util.RacingGameManager;
import racingcar.controller.RacingGame;
import racingcar.view.OutputView;

import java.util.ArrayList;

public class RacingGameConfig {

    public RacingGame initRacingGame() {
        RacingGameManager racingGameManager = new RacingGameManager(new ArrayList<>());
        GameResultMaker gameResultMaker = new GameResultMaker();
        OutputView outputView = new OutputView();
        return new RacingGame(racingGameManager, gameResultMaker, outputView);
    }
}
