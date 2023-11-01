package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Controller.RacingGameController;
import racingcar.Model.Car;
import racingcar.View.RacingGameView;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름_테스트() {
        RacingGameView view = new RacingGameView();
        String[] carNames = {"verylongcarname", "short"};
        assertThatThrownBy(() -> new RacingGameController(Arrays.asList(carNames), view))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
    }


    @Test
    void 게임_횟수_음수_테스트() {
        RacingGameController controller = new RacingGameController(Arrays.asList("pobi", "woni"), new RacingGameView());

        assertThatThrownBy(() -> controller.startGame(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("게임 횟수는 1 이상이어야 합니다.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}