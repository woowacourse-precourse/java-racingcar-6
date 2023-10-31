package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

class ApplicationTest_add extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지_예제_동일_조건() {
        List<String> exampleOutput = List.of(
                "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)",
                "시도할 회수는 몇회인가요?",
                "실행 결과",
                "pobi : -",
                "woni : ",
                "jun : -",
                "",
                "pobi : --",
                "woni : -",
                "jun : --",
                "",
                "pobi : ---",
                "woni : --",
                "jun : ---",
                "",
                "pobi : ----",
                "woni : ---",
                "jun : ----",
                "",
                "pobi : -----",
                "woni : ----",
                "jun : -----",
                "",
                "최종 우승자 : pobi, jun");

        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "5");
                    assertThat(output()).containsSubsequence(exampleOutput);
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD);
    }

    @Test
    void 이름에_대한_예외_처리_길이초과_시작() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("javaji,pobi", "1"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 이름에_대한_예외_처리_길이초과_중간() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,javaji,woni", "1"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 이름에_대한_예외_처리_길이초과_끝() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 이름에_대한_예외_처리_빈문자열() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("", "1"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 이름에_대한_예외_처리_빈이름_시작() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException(",javaj", "1"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 이름에_대한_예외_처리_빈이름_중간() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("javaj,,wonni", "1"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 이름에_대한_예외_처리_빈이름_끝() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("javaj,", "1"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 이름에_대한_예외_처리_쉼표() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException(",", "1"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 이름에_대한_예외_처리_쉼표_연속() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 실행_횟수에_대한_예외_처리_0() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,woni,jun", "0"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 실행_횟수에_대한_예외_처리_음수() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,woni,jun", "-1"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 실행_횟수에_대한_예외_처리_소수() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,woni,jun", "1.1"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 실행_횟수에_대한_예외_처리_문자열() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,woni,jun", "a"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 실행_횟수에_대한_예외_처리_빈문자열() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,woni,jun", null))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 실행_횟수에_대한_예외_처리_긴문자열() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,woni,jun", "abcdefghijklmnopqrstuvwxyz"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 실행_횟수에_대한_예외_처리_Long_최대값_초과() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,woni,jun", "9223372036854775808"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 실행_횟수에_대한_예외_처리_Long_최소값_미만() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,woni,jun", "-9223372036854775809"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[] {});
    }
}
