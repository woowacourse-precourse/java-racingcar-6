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
    void 이름에_대한_예외_처리_이름이_공백() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_예외_이름에_공백만_있음() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("woni,  ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_성공_이름에_공백이_껴있음_성공() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi, w o ", "1");
                    assertThat(output()).contains("pobi : -", " w o  : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리_이름이_다섯글자_초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_예외_처리_맨앞_콤마() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",pobi,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_예외_처리_연속된_콤마() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    /**
     * 자바 split 매서드 동작 방식과 같은 방법을 이용
     */
    @Test
    void 이름에_대한_성공_맨뒤_콤마() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 숫자에_대한_예외_처리_숫자가_아님() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "one"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    /**
     * 숫자: 레이싱 라운드 횟수
     * 나는 숫자 최대값 범위를 Integer.MAXVALUE 로 지정했다. = 2147483647
     * Integer.ParseInt 가 예외를 잡아준다.
     */
    @Test
    void 숫자에_대한_예외_처리_숫자가_최대_범위를_넘음() {
        System.out.println(Integer.MAX_VALUE);
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "2147483648"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자에_대한_예외_처리_숫자는_양수만_가능() {
        System.out.println(Integer.MAX_VALUE);
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    /**
     * NumberFormatException - catch 후 IllegalArgumentException 던지기
     * NumberFormatException : IllegalArgumentException 의 자식 으로 같은 종류의 예외지만 우선 catch 했다.
     */
    @Test
    void 숫자에_대한_예외_처리_중간에_공백() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "2 1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자에_대한_성공_맨앞_맨뒤_공백은_trim_으로_잡는다() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", " 1 ");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
