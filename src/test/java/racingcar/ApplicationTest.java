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
    void 이름_길이가_5글자_이상_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("banana,jajava"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_구분이_띄움표시_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("bana jaja"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_구분이_콤마외의_문자_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("bana-jaja"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_입력_빈칸_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",jaja"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 이름_중복_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi,java"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_입력_마지막에_콤마로_끝났는지_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,bee,sudo,java,"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수_0번_이하_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수_숫자외_입력_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "f"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
