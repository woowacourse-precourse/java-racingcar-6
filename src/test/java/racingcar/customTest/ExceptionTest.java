package racingcar.customTest;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class ExceptionTest extends NsTest {
    @Test
    void 이름에_대한_예외_처리1_1자_이상() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_예외_처리2_5자_이하() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_예외_처리3_SPLIT_전_이름_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 경주_자동차_개수에_대한_예외_처리1_1개_이상() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_회수에_대한_예외_처리1_숫자만_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "woni"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_회수에_대한_예외_처리2_양수만_입력1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_회수에_대한_예외_처리2_양수만_입력2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
