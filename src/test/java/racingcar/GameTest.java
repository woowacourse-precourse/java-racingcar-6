package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {
    private Game game;

    @BeforeEach
    private void SetUp(){
        game = new Game();
    }

    @Test
    void 최솟값_최댓값사이의_랜덤한_수_생성하기() {
        int result = game.setRandNum();
        Assertions.assertTrue(result >= Config.MIN_VALUE && result <= Config.MAX_VALUE);
    }
}
