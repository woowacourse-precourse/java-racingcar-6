package racingcar.domain.game;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.Game;

public class GameSettingTest extends NsTest {

    private static final String YOUTH = "youth";
    private static final String SONNY = "son";
    private static final String DELIMITER = ",";
    private static final String GAME_COUNT_STRING = "1";
    private static final Long GAME_COUNT = 1L;

    private Game game = new Game();

    @Test
    void 게임_세팅_자동차_확인(){
        assertSimpleTest(() -> {
                    run(YOUTH+DELIMITER+SONNY, GAME_COUNT_STRING);
                    assertThat(game.getCarNames()).contains(YOUTH);
                    assertThat(game.getCarNames()).contains(SONNY);
                }
        );
    }

    @Test
    void 게임_세팅_시도횟수_확인(){
        assertSimpleTest(() -> {
                    run(YOUTH+DELIMITER+SONNY, GAME_COUNT_STRING);
                    assertEquals(GAME_COUNT,game.getGameCount());
                }
        );
    }

    @Override
    protected void runMain() {
        game.raceSetting();
    }
}
