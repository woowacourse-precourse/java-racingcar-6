package mytest;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;


import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class FunctionTest  extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    // 자동차 이름 입력 관련
    @Test
    void 중복된_이름_제거() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,pobi", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 구분자가_포함되지_않은_경우_값을_그대로_반환() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "1");
                    assertThat(output()).contains("pobi : -", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void exception_자동차_이름_공백경우_예외발생1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,,c", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void exception_자동차_이름_공백경우_예외발생2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,b,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void exception_자동차_이름_공백경우_예외발생3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",a,b", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void exception_자동차_이름_공백경우_예외발생4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void exception_자동차_이름_입력_없는경우_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javajisfsedfsdfsdfsdf", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // 이동 횟수 입력 확인
    @Test
    void 잘못된_이동횟수_입력_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이동횟수_공백입력_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", " "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 잘못된_이동횟수_형식입력_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "ㄴㅇㄱ"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 전진_후진_결과확인() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,pobi", "3");
                    assertThat(output()).contains("pobi : --", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP,MOVING_FORWARD, STOP,STOP, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
