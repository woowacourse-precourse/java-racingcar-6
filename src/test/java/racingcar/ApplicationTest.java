package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.message.ErrorMessage;

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
    void 전진_전진() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 정지_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : ", "woni : ", "최종 우승자 : pobi, woni");
                },
                STOP, STOP
        );
    }

    @Test
    void 예시_출력_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "5");
                    assertThat(output()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)",
                            "시도할 회수는 몇회인가요?", "실행 결과",
                            "pobi : -----", "woni : ----", "jun : -----", "최종 우승자 : pobi, jun");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD);
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_예외_처리_쉼표가_아닌_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi  woni mike", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_CAR_NAME)
        );
    }

    @Test
    void 이름에_대한_예외_처리_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_CAR_NAME)
        );
    }

    @Test
    void 시도_횟수에_대한_예외_처리_빈_값인_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", " "))
                       .isInstanceOf(IllegalArgumentException.class)
                       .hasMessage(ErrorMessage.INPUT_BLANK)
        );
    }

    @Test
    void 시도_횟수에_대한_예외_처리_숫자가_아닌_경우_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "one"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INPUT_NOT_INTEGER)
        );
    }

    @Test
    void 시도_횟수에_대한_예외_처리_숫자가_아닌_경우_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "1a2"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INPUT_NOT_INTEGER)
        );
    }

    @Test
    void 시도_횟수에_대한_예외_처리_숫자가_음수인_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_NEGATIVE)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
