package racingcar;

import java.util.ArrayList;

public class RacingGameConfig {

    public RacingGame initRacingGame() {
        RacingGameManager racingGameManager = new RacingGameManager(new ArrayList<>());
        GameResultMaker gameResultMaker = new GameResultMaker();
        GameResultView gameResultView = new GameResultView();
        return new RacingGame(racingGameManager, gameResultMaker, gameResultView);
    }
}
