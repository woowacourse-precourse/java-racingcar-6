package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

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
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jun", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_저장() {
        GameManager gameManager = GameManager.getInstance();
        List<Car> list = gameManager.setCarList("car1,car2");

        assertThat(list.size()).isEqualTo(2);
        assertThat(list.get(0).name).isEqualTo("car1");
        assertThat(list.get(1).name).isEqualTo("car2");
    }

    @Test
    void 시도횟수_저장() {
        GameManager gameManager = GameManager.getInstance();
        int roundNum = gameManager.setRoundNum("3");

        assertThat(roundNum).isEqualTo(3);
    }

    @Test
    void 시도횟수_끝났는지_확인() {
        GameManager gameManager = GameManager.getInstance();
        assertThat(gameManager.checkGameFinished(0)).isTrue();
        assertThat(gameManager.checkGameFinished(3)).isFalse();
    }

    @Test
    void 우승여부_우승자_확인() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("hay,ohyo", "2");
                    assertThat(output()).contains("hay : --", "ohyo : -", "최종 우승자 : hay");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
