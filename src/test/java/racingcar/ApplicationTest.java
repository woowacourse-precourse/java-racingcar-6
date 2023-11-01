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
    void 특수문자_포함된_이름_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,nimo!", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 공백_포함된_이름_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,ni mo", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_포함된_이름_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,n1mo", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 쉼표_이외의_구분자_활용한_경우_에외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi/nimo/crong", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_사이_구분자_공백_있는_경우_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, nimo, crong", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 한개_이름_입력_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
