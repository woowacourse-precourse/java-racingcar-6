package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationSecondTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 게임_결과에_대한_검증() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("aa,bb,cc", "1");
                    assertThat(output()).contains("aa : ", "bb : -", "cc : ", "최종 우승자 : bb");
                },
                STOP, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 게임_결과에_대한_검증_2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("aa,bb,cc", "1");
                    assertThat(output()).contains("aa : ", "bb : -", "cc : -", "최종 우승자 : bb, cc");
                },
                STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 게임_결과에_대한_검증_3() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("aa,bb", "00003");
                    assertThat(output()).contains("aa : ", "bb : -", "aa : -", "bb : --", "aa : --", "bb : ---",
                                    "최종 우승자 : bb")
                            .doesNotContain("aa : ---");
                },
                STOP, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 게임_결과에_대한_검증_4() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("aa,bb", "0000000003");
                    assertThat(output()).contains("aa : ", "aa : -", "aa : --", "bb : -",
                                    "최종 우승자 : aa")
                            .doesNotContain("bb : --");
                },
                STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 긴_문자열_이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("banana,apple", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 긴_문자열_이름에_대한_예외_처리_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("infikei", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 긴_문자열_이름에_대한_예외_처리_3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("infikeiinfikeiinfikeiinfikei", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈_문자열_이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈_문자열_이름에_대한_예외_처리_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("infi,,kei", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈_문자열_이름에_대한_예외_처리_3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",infi,kei", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈_문자열_이름에_대한_예외_처리_4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("infi,kei,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈_문자열_이름에_대한_예외_처리_5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",,,,,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 정수가_아닌_전진_시도_횟수에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("aa,bb", "abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 정수가_아닌_전진_시도_횟수에_대한_예외_처리_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("aa,bb", "3.1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 정수가_아닌_전진_시도_횟수에_대한_예외_처리_3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("aa,bb", "3.0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 정수가_아닌_전진_시도_횟수에_대한_예외_처리_4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("aa,bb", "0.0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 양의_정수가_아닌_전진_시도_횟수에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("aa,bb", "-2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 양의_정수가_아닌_전진_시도_횟수에_대한_예외_처리_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("aa,bb", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
