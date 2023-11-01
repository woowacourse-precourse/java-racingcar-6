package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

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
    @DisplayName("자동차 이름 입력을 요청한다.")
    void 자동차_이름_입력_요청하기() {
        run("pobi,woni", "1");
        assertThat(output()).contains(CAR_NAME_INPUT_MESSAGE);
    }

    @Test
    @DisplayName("round 횟수 입력을 요청한다.")
    void 라운드_횟수_입력_요청하기() {
        run("pobi,woni", "1");
        assertThat(output()).contains(ROUND_INPUT_MESSAGE);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
