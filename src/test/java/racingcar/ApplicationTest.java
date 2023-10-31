package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지_예제코드_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni,jun", "5");
                assertThat(output())
                    .contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
                    .contains("시도할 회수는 몇회인가요?")
                    .contains("실행 결과")
                    .contains("pobi : -", "woni :", "jun : -")
                    .contains("pobi : --", "woni : -", "jun : --")
                    .contains("pobi : ---", "woni : --", "jun : ---")
                    .contains("pobi : ----", "woni : ---", "jun : ----")
                    .contains("pobi : -----", "woni : ----", "jun : -----")
                    .contains("최종 우승자 : pobi, jun");
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 전진_정지_우승자_두명() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni,jun", "1");
                assertThat(output())
                    .contains("pobi : -", "woni : -", "jun : ", "최종 우승자 : pobi, woni");
            },
            MOVING_FORWARD, MOVING_FORWARD, STOP
        );

        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni,jun", "1");
                assertThat(output())
                    .contains("pobi : -", "woni : ", "jun : -", "최종 우승자 : pobi, jun");
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD
        );

        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni,jun", "1");
                assertThat(output())
                    .contains("pobi : ", "woni : -", "jun : -", "최종 우승자 : woni, jun");
            },
            STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 전진_정지_우승자_한명() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );

        assertRandomNumberInRangeTest(
            () -> {
                run("woni,pobi", "1");
                assertThat(output()).contains("woni : -", "pobi : ", "최종 우승자 : woni");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이동_횟수에_대한_예외_처리_숫자가_아님() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi", "woni", "a"))
                .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi", "woni", "!"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 정상적인_이름과_이동_횟수() {
        assertSimpleTest(() ->
            assertThatCode(() -> runException("pobi,javaj", "1"))
                .doesNotThrowAnyException()
        );
    }

    @Test
    void 이름에_대한_예외_처리_nothing() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(",", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_예외_처리_empty() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_예외_처리_6_자리_이상() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobiii,javaj", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobiii,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
