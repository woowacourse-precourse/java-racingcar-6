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
    void 잘못된_자동차명_예외발생_5자넘는자동차() {
        assertSimpleTest(
                () -> {
                    assertThatThrownBy(() -> runException("abcde,abcdef", "1"))
                            .isInstanceOf(IllegalArgumentException.class);
                }
        );
    }

    @Test
    void 잘못된_자동차명_예외발생_이름이_1자_미만인_자동차() {
        assertSimpleTest(
                () -> {
                    assertThatThrownBy(() -> runException("abcde,  ,abc", "10"))
                            .isInstanceOf(IllegalArgumentException.class);
                }
        );
    }

    @Test
    void 입력한_반복수만큼_순회() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,", "4");
                    assertThat(output()).contains("pobi : ----", "woni : ----", "최종 우승자 : pobi,woni");
                },
                MOVING_FORWARD, MOVING_FORWARD , MOVING_FORWARD , MOVING_FORWARD , MOVING_FORWARD , MOVING_FORWARD , MOVING_FORWARD , MOVING_FORWARD
        );
    }

    @Test
    void 랜덤값_4가넘을경우_전진() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains("pobi : --", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP , MOVING_FORWARD , STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
