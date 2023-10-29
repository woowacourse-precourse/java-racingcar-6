package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ValidatorTest {

    @Test
    @DisplayName("자동차 이름이 두 대 이상이 아닐 경우 IllegalArgumentException 발생")
    void oneCarExceptionTest() {
        // given
        String cars = "pobi";

        // when

        // then
        assertThatThrownBy(() -> GameValidator.validateCarNumberIsOverTwo(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차는 두 대 이상이어야 합니다.");
    }

    @Test
    @DisplayName("자동차가 두 대 이상일 경우 예외가 발생하지 않는다.")
    void twoCarNoExceptionTest() {
        // given
        String cars = "pobi,woni";

        // when

        // then
        assertThatNoException().isThrownBy(() -> GameValidator.validateCarNumberIsOverTwo(cars));
    }

    @Test
    @DisplayName("자동차 이름이 공백일 경우 예외 발생")
    void test() {
        // given
        String cars = "pobi,";

        // when

        // then
        assertThatThrownBy(() -> GameValidator.validateZeroCarName(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1글자 이상 5글자 이하만 가능합니다.");
    }

    @Test
    @DisplayName("자동차 이름이 1글자 이상 5글자 이하가 아닐 경우 IllegalArgumentException 발생")
    void nameLengthExceptionTest() {
        // given
        String car = "javajigi";

        // when

        // then
        assertThatThrownBy(() -> GameValidator.validateCarNamesLength(car))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1글자 이상 5글자 이하만 가능합니다.");
    }

    @Test
    @DisplayName("자동차 이름이 1글자 이상 5글자 이하일 경우 예외가 발생하지 않는다.")
    void nameLengthNoExceptionTest() {
        // given
        String car = "pobi";

        // when

        // then
        assertThatNoException().isThrownBy(() -> GameValidator.validateCarNamesLength(car));
    }

    @Test
    @DisplayName("시도 회수가 1이상 1000이하가 아닐 경우 IllegalArgumentException 발생")
    void validateTryCountIsNumber() {
        // given
        int tryCount = 0;

        // when

        // then
        assertThatThrownBy(() -> GameValidator.validateTryCount(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1 이상 1000 이하의 숫자만 가능합니다.");
    }

    @Test
    @DisplayName("시도 회수가 1이상 1000이하가 아닐 경우 IllegalArgumentException 발생")
    void validateTryCountOverThousand() {
        // given
        int tryCount = 1001;

        // when

        // then
        assertThatThrownBy(() -> GameValidator.validateTryCount(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1 이상 1000 이하의 숫자만 가능합니다.");
    }

    @Test
    @DisplayName("시도 회수가 1이상 1000이하면 예외가 발생하지 않는다.")
    void noExceptionMaxTryCount() {
        // given
        int tryCount = 1000;

        // when

        // then
        assertThatNoException().isThrownBy(() -> GameValidator.validateTryCount(tryCount));
    }

    @Test
    @DisplayName("시도 회수가 1일땐 예외가 발생하지 않는다.")
    void noExceptionMinTryCount() {
        // given
        int tryCount = 1;

        // when

        // then
        assertThatNoException().isThrownBy(() -> GameValidator.validateTryCount(tryCount));
    }
}
