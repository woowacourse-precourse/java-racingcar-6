package racingcar.domain;

import org.assertj.core.error.uri.ShouldHaveUserInfo;
import racingcar.util.UserInputUtil;

import java.util.List;

/*
* 게임 실행
* */
public class GameManager {

    private RacingCarManager racingCarManager;
    private int tries;

    public void startGame() throws IllegalArgumentException {
        initializeGame();
        playGame();
        endGame();
    }

    private void initializeGame() {
        List<String> carNameList = UserInputUtil.getCarNames();

    }

    private void playGame() {

    }

    private void endGame() {

    }
}
