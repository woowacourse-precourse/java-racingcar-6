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
    void 이름_구분_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi javaj", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 글자수_제한_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abcdefghijk,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 회수가_아닌_값_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc,pobi", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_중복_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc,abc,abc", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 공동_우승() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,abc", "1");
                    assertThat(output()).contains("pobi : ", "woni : ", "abc : ", "최종 우승자 : pobi, woni, abc");
                },
                5, 5, 5
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
