package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
                assertThatThrownBy(() -> runException("  pobi , javaji ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복_우승자_선정_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "5");
                    assertThat(output()).contains("최종 우승자 : pobi, jun");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                STOP, STOP, MOVING_FORWARD
        );
    }

    @ParameterizedTest
    @CsvSource({"'a'", "'!!'", "' '", "'0'", "'ㄱ'"})
    void 시도횟수_예외_처리(String tryCount) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", tryCount))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("레이스의 참여한 자동차는 2대 이상이여야 한다.")
    public void validateNumberOfCar() {

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("레이스의 참여한 자동차의 이름은 중복되면 안된다.")
    public void validateDuplicateCarNames() {

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi,jun"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
