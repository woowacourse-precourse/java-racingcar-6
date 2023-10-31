package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.message.ValidateErrorMessage;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.internal.bytebuddy.implementation.MethodCall.run;

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
    @DisplayName("이동 결과만큼 실행 결과가 출력된다.")
    void 실행결과_테스트(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("runa,crong,boo", "4");
                    assertThat(output()).contains("runa : ---", "crong : -", "boo : ----", "최종 우승자 : boo");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                STOP, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
