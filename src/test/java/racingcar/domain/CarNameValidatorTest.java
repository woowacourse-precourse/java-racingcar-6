package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameValidatorTest {

    @DisplayName("모든 경우의 수를 따져서 올바른 carName일 경우에는 예외가 발생하지 않는다.")
    @Test
    void validateAllCasesDoesNotThrowAnyException() {
        // given
        String validCarName = "sully";

        // when
        // then
        assertThatCode(() -> new CarNameValidator(validCarName))
                .doesNotThrowAnyException();
    }

    @DisplayName("validateCarNameExists()로 자동차 이름을 입력하지 않으면 ''으로 저장되기 때문에 예외가 발생한다.")
    @Test
    void validateCarNameExistsWithBlank() {
        // given
        String invalidCarName = "";

        // when
        // then
        assertThatThrownBy(() -> new CarNameValidator(invalidCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름을 입력해주세요.");
    }

    @DisplayName("validateAlphanumericAndCommaCarName()로 자동차 이름이 영숫자와 콤마로만 구성되지 않는 경우 예외가 발생한다.")
    @Test
    void validateAlphanumericAndCommaCarNameWithInvalidCarName() {
        // given
        String invalidCarName = "sully^^";

        // when
        // then
        assertThatThrownBy(() -> new CarNameValidator(invalidCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 영숫자와 콤마로만 구성되어야 합니다.");
    }

}
