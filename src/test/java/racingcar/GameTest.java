package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingGame;

public class GameTest {
    private static final List<String> PLAYER = Arrays.asList("aaa", "bbb", "ccc");
    private RacingGame game;

    @BeforeEach
    void setUp(){
        game = new RacingGame(PLAYER);
    }

    @Test
    void 단독_우승(){
        game.moveForwardIndex(0);
        assertThat(game.getWinnerNames()).hasSize(1)
                .contains("aaa");
    }

    @Test
    void 동시_우승(){
        game.moveForwardIndex(0);
        game.moveForwardIndex(1);
        game.moveForwardIndex(2);

        assertThat(game.getWinnerNames()).hasSize(3)
                .contains("aaa", "bbb", "ccc");
    }
}
