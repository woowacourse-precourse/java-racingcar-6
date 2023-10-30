package racingcar.acceptance;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Application;

public class AcceptanceTest extends NsTest {

    private static final int MOVING_FORWARD = 4;

    private static final int STOP = 3;

    @Test
    void 우승자는_가장_멀리_간_자동차다() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains("pobi : --", "woni : -", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 우승자가_두명_이상이면_모두_포함한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,vec", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "vec : -", "최종 우승자 : pobi, woni, vec");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 이름이_올바르지_않으면_예외를_던진다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi1,pobi2,pobi3,pobi4,pobi5,pobi6", "pobi"})
    void 차의_개수가_2에서_5가_아니면_예외를_던진다(final String carNames) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(carNames, "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름이_중복되면_예외를_던진다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "31"})
    void 시도_횟수가_1에서_30이_아니면_예외를_던진다(final String time) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", time))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
