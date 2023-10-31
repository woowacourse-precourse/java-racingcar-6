package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 게임_진행_결과와_최종_우승자를_출력한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : ", "woni : ", "최종 우승자 : ");
                },
                MOVING_FORWARD, STOP
        );
    }

    @MethodSource("carNamesProvider")
    @ParameterizedTest
    void 자동차_이름이_올바르지_않으면_예외가_발생한다(String carNames) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(carNames, "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    static Stream<String> carNamesProvider() {
        return Stream.of("pobi,javaji", "", " , ");
    }

    @CsvSource({"a", "0", "' '", "abcd"})
    @ParameterizedTest
    void 시도_횟수가_올바르지_않으면_예외가_발생한다(String attemptNumber) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", attemptNumber))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    @Test
    void 자동차_이름과_시도할_횟수를_입력받는다() {
        assertSimpleTest(
                () -> {
                    run("pobi,woni,goood", "5");
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
