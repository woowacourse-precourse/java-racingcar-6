package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.util.TestConstantsProvider.provideInvalidCarNameConstants;
import static racingcar.util.TestConstantsProvider.provideValidCarNameConstants;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.view.ConsoleInput;

public class ConsoleInputTest {

    @Nested
    @TestInstance(Lifecycle.PER_CLASS)
    @DisplayName("자동차 이름 입력 기능")
    class CarNamesInputTest extends NsTest {

        @ParameterizedTest(name = "{0}대의 차를 입력한다.")
        @DisplayName("성공 테스트")
        @MethodSource("provideValidCarNames")
        void successTest(String validCarName, List<String> expectedCarName) {
            assertRandomNumberInRangeTest(
                    () -> {
                        run(validCarName);
                        assertThat(output()).contains(expectedCarName);
                    }, 1
            );
        }

        @ParameterizedTest(name = "{0}을 입력하면 예외가 발생한다.")
        @DisplayName("예외 테스트")
        @MethodSource(value = "provideInvalidCarNames")
        void exceptionTest(String invalidCarName) {

            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(invalidCarName))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        private Stream<Arguments> provideValidCarNames() {
            return provideValidCarNameConstants();
        }

        private Stream<Arguments> provideInvalidCarNames() {
            return provideInvalidCarNameConstants();
        }


        @Override
        protected void runMain() {
            System.out.println(ConsoleInput.inputCarNames());
        }
    }
}
