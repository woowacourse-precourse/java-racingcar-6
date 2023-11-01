package racingcar.domain.player;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.Player;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class InputGameCountTest extends NsTest {

    private Player player = new Player();

    @Test
    void 게임_횟수_입력(){
        assertSimpleTest(() -> {
                    run("2");
                    assertThat(player.getGameCount()).isEqualTo(2L);
                }
        );
    }

    @Override
    protected void runMain() {
        player.inputGameCount();
    }
}
