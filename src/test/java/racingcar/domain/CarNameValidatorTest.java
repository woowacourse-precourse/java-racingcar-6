package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameValidatorTest {

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

    @DisplayName("validateCarNameExists()로 자동차 이름을 입력하면 예외가 발생하지 않는다.")
    @Test
    void validateCarNameExists() {
        // given
        String validCarName = "sully";

        // when
        // then
        assertThatCode(() -> new CarNameValidator(validCarName))
                .doesNotThrowAnyException();
    }

}
