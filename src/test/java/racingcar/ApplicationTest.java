package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @ParameterizedTest
    @DisplayName("경주 횟수에 대한 예외 처리")
    @ValueSource(strings = {"-1", "0", "eng", "한글"})
    void raceCountFailTest(String raceCount) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", raceCount))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("우승자 여러명")
    void winnersTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,eora", "1");
                    assertThat(output()).contains("pobi : -", "woni : ","eora : -", "최종 우승자 : pobi, eora");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }
}
