package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

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
    void 중복_이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jun,pobi", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수_입력_숫자_아닌_경우_예외_처리() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,woni", "t"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수_입력_0인_경우_예외_처리() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,woni", "0"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수_입력_음수인_경우_예외_처리() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 우승자_여러명() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi,woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 한칸_전진_테스트() {
        int lastPosition = 1;

        assertRandomNumberInRangeTest(
                () -> {
                    Integer result = RacingCarGame.carMoveForwardResult(lastPosition);
                    assertThat(result).isEqualTo(lastPosition + 1);
                },
                MOVING_FORWARD
        );
    }

    @Test
    void 전진_불가능_테스트() {
        int lastPosition = 1;

        assertRandomNumberInRangeTest(
                () -> {
                    Integer result = RacingCarGame.carMoveForwardResult(lastPosition);
                    assertThat(result).isEqualTo(lastPosition);
                },
                STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
