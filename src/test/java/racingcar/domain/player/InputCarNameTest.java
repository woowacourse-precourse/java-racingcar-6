package racingcar.domain.player;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.Player;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class InputCarNameTest extends NsTest {

    private Player player = new Player();

    @Test
    void 자동차_입력_기능() {
        assertSimpleTest(() -> {
                    run("youth,sonny");
                    assertThat(player.getCarNames()).contains("youth");
                    assertThat(player.getCarNames()).contains("sonny");
                }
        );
    }

    @Override
    protected void runMain() {
        player.inputCarNames();
    }
}
