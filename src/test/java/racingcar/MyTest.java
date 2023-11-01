package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class MyTest extends NsTest {
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
    void 자동차_이름의_길이가_5를_넘을_경우_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi123,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 라운드_수가_정수가_아닌_경우_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 라운드_수가_0인_경우_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 라운드_수가_음수인_경우_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 동일한_이름의_자동차가_있을_경우_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름을_미입력한_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_사이에_공백이_있는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,wo ni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름에_특수문자가_있는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("po@bi,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 우승자가_다수인_경우() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi,woni,yhcho", "1");
            assertThat(output()).contains("최종 우승자 : pobi, woni, yhcho");
        }, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD);
    }

    @Test
    void 우승자가_다수인_경우_모두_0칸_이동한_경우() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi,woni", "1");
            assertThat(output()).contains("최종 우승자 : pobi, woni");
        }, STOP, STOP);
    }

    @Test
    void 우승자가_한_명인_경우() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi,woni", "1");
            assertThat(output()).contains("최종 우승자 : woni");
        }, STOP, MOVING_FORWARD);
    }

    @Test
    void 자동차가_한_대만_있는_경우() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi", "1");
            assertThat(output()).contains("최종 우승자 : pobi");
        }, MOVING_FORWARD);
    }


    @Test
    void 무작위_값이_4_이상일_때만_전진() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi", "1");
            assertThat(output()).contains("pobi : -");
        }, 4, 1);

        assertRandomNumberInRangeTest(() -> {
            run("pobi", "1");
            assertThat(output()).contains("pobi : ");
        }, 0, 3);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
