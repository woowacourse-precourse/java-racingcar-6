package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    GameProgression gameProgression = new GameProgression();
    GameResult gameResult = new GameResult(gameProgression);

    public void gameStart() {
        gameProgression.resultsPerGame();
        gameResult.GameEndResults();
    }

}

