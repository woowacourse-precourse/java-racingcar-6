package racingcar.domain.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.MessageConstants.CAR_NAME_ALPHANUMERIC_COMMA_ONLY;
import static racingcar.constant.MessageConstants.CAR_NAME_DUPLICATE;
import static racingcar.constant.MessageConstants.CAR_NAME_MAX_LENGTH_EXCEEDED;
import static racingcar.constant.MessageConstants.CAR_NAME_NOT_PROVIDED;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Utils;

class CarNameValidatorTest {

    @DisplayName("모든 경우의 수를 따져서 올바른 carName일 경우에는 예외가 발생하지 않는다.")
    @Test
    void validate_all_cases_does_not_throw_any_exception() {
        // given
        String validCarName = "i,am,sully";
        List<String> carNames = Utils.parseCarName(validCarName);

        // when
        CarNameValidator carNameValidator = new CarNameValidator(carNames);

        // then
        assertThatCode(carNameValidator::validateAll)
                .doesNotThrowAnyException();
    }

    @DisplayName("validateCarNameExists()로 자동차 이름을 입력하지 않으면 ''으로 저장되기 때문에 예외가 발생한다.")
    @Test
    void validate_carName_exists_with_blank() {
        // given
        String invalidCarName = "sully,,i";
        List<String> carNames = Utils.parseCarName(invalidCarName);

        // when
        CarNameValidator carNameValidator = new CarNameValidator(carNames);

        // then
        assertThatThrownBy(carNameValidator::validateAll)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_NOT_PROVIDED);
    }

    @DisplayName("validateAlphanumericAndCommaCarName()로 자동차 이름이 영숫자와 콤마로만 구성되지 않는 경우 예외가 발생한다.")
    @Test
    void validate_alphanumeric_and_comma_carName_with_invalid_carName() {
        // given
        String invalidCarName = "i,am,siu^^";
        List<String> carNames = Utils.parseCarName(invalidCarName);

        // when
        CarNameValidator carNameValidator = new CarNameValidator(carNames);

        // then
        assertThatThrownBy(carNameValidator::validateAll)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_ALPHANUMERIC_COMMA_ONLY);
    }

    @DisplayName("validateCarNameLength()로 자동차 이름의 길이가 0에서 5글자가 아니라면 예외가 발생한다.")
    @Test
    void validate_carName_length_with_invalid_length() {
        // given
        String invalidCarName = "romero,sully,hi";
        List<String> carNames = Utils.parseCarName(invalidCarName);

        // when
        CarNameValidator carNameValidator = new CarNameValidator(carNames);

        // then
        assertThatThrownBy(carNameValidator::validateAll)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_MAX_LENGTH_EXCEEDED);
    }

    @DisplayName("validateCarNamesDuplicate()로 자동차 이름들이 중복된다면 예외가 발생한다.")
    @Test
    void validate_carNames_duplicate_with_invalid_carNames() {
        // given
        String invalidCarName = "sully,hi,my,name,is,sully";
        List<String> carNames = Utils.parseCarName(invalidCarName);

        // when
        CarNameValidator carNameValidator = new CarNameValidator(carNames);

        // then
        assertThatThrownBy(carNameValidator::validateAll)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_DUPLICATE);
    }

}
