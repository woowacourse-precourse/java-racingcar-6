package racingcar.util;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Application;

@DisplayName("유효하지 않은 입력값 테스트")
class InputUtilTest extends NsTest {

    @Nested
    @DisplayName("유효하지 않은 자동차 이름 입력값 테스트")
    class CarNameInputTest {

        @ParameterizedTest
        @ValueSource(strings = {"tesla,tesla,bmw", "tesla,tesla,tesla", "tesla,tesla, bmw, bmw"})
        void 중복된_자동차이름_입력시_예외발생(String carNameInput) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(carNameInput))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 유효하지_않은_길이의_자동차_이름_입력시_예외발생() {
            String carNameInput = "rangerover,lamborghini,rollsroyce";
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(carNameInput))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @ParameterizedTest
        @ValueSource(strings = {"tesla", "bmw, ford, audi, mazda, tesla, honda, kia, fiat, jeep, volvo, mini"})
        void 유효하지_않은_길이의_자동차_수_입력시_예외발생(String carNameInput) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(carNameInput))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @ParameterizedTest
        @ValueSource(strings = {"teSla,테슬라,zeep1", "zeep ,1234,     ", "?!@!,%^$&,;;@@,+_90"})
        void 유효하지_않은_형식의_자동차_이름_입력시_예외발생(String carNameInput) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(carNameInput))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Nested
    @DisplayName("유효하지 않은 경주 횟수 입력값 테스트")
    class TrialInputTest {

        @ParameterizedTest
        @ValueSource(strings = {"-1", "0", "21", "10000", "20231101"})
        void 유효하지_않은_범위의_경주횟수_입력시_예외발생(String trialInput) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,javaji", trialInput))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @ParameterizedTest
        @ValueSource(strings = {"s", "ab", "2s", " ", "가나다"})
        void 유효하지_않은_형식의_경주횟수_입력시_예외발생(String trialInput) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,javaji", trialInput))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}