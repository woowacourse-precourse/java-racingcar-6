package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.validator.CarNameValidator;

class CarNameValidatorTest {

    @DisplayName("모든 경우의 수를 따져서 올바른 carName일 경우에는 예외가 발생하지 않는다.")
    @Test
    void validateAllCasesDoesNotThrowAnyException() {
        // given
        String validCarName = "i,am,sully";

        // when
        // then
        assertThatCode(() -> new CarNameValidator(validCarName))
                .doesNotThrowAnyException();
    }

    @DisplayName("validateCarNameExists()로 자동차 이름을 입력하지 않으면 ''으로 저장되기 때문에 예외가 발생한다.")
    @Test
    void validateCarNameExistsWithBlank() {
        // given
        String invalidCarName = "sully,,i";

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
        String invalidCarName = "i,am,siu^^";

        // when
        // then
        assertThatThrownBy(() -> new CarNameValidator(invalidCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 영숫자와 콤마로만 구성되어야 합니다.");
    }

    @DisplayName("validateCarNameLength()로 자동차 이름의 길이가 0에서 5글자가 아니라면 예외가 발생한다.")
    @Test
    void validateCarNameLengthWithInvalidLength() {
        // given
        String invalidCarName = "romero,sully,hi";

        // when
        // then
        assertThatThrownBy(() -> new CarNameValidator(invalidCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5글자 이하여야 합니다.");
    }

    @DisplayName("validateCarNamesDuplicate()로 자동차 이름들이 중복된다면 예외가 발생한다.")
    @Test
    void validateCarNamesDuplicateWithInvalidCarNames() {
        // given
        String invalidCarName = "sully,hi,my,name,is,sully";

        // when
        // then
        assertThatThrownBy(() -> new CarNameValidator(invalidCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복될 수 없습니다.");
    }

}
