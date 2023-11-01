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
    void 같은_이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_입력_공백에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_입력_중간_공백에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("d f", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 라운드_입력_공백에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", ""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 라운드_입력_중간_공백에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("do,fo", "1 2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 라운드_문자_입력_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("do,fo", "d"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 라운드_범위_초과_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("do,fo", String.valueOf(Integer.MAX_VALUE + 1)))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 라운드_범위_미만_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("do,fo", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
