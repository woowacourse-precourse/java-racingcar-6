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
    void 자동차_이름_공백_입력시_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1가"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("공백 또는 여백이 포함되어 있습니다."));
    }

    @Test
    void 자동차_이름_중복_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("[중복 불가] 자동차 이름은 서로 다르게 입력해주세요."));
    }


    @Test
    void 자동차_이름_특수문자_입력시_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("!@#!"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("차 이름은 영어 또는 한글만 가능합니다."));
    }

    @Test
    void 시도할_회수_공백_입력_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", " "))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("공백 또는 여백이 포함되어 있습니다."));
    }

    @Test
    void 시도할_회수_문자_입력_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "숫자"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("시도할 회수는 숫자만 가능"));
    }

    @Test
    void 시도할_회수_음수_입력_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("1 이상의 양수만 입력 가능."));
    }

    @Test
    void 시도할_회수_0_입력_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("1 이상의 양수만 입력 가능."));
    }

    @Test
    void 공동_우승자_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "5");
                    assertThat(output()).contains("최종 우승자 : pobi, woni");
                },
                4, 4
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
