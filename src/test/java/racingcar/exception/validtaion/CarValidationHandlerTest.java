package racingcar.exception.validtaion;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarValidationHandlerTest {

    @Test
    @DisplayName("문자열이 5글자 이하이면 예외가 발생하지 않는다.")
    void isCarNameUnder5LengthTrue() {
        // given
        String carName = "ppobi";

        // when // then
        CarValidationHandler.validationCarNameUnder5Length(carName);
    }

    @Test
    @DisplayName("문자열이 5글자 초과이면 예외가 발생한다.")
    void isCarNameUnder5LengthFalse() {
        // given
        String carName = "ppobii";

        // when // then
        assertThatThrownBy(() -> CarValidationHandler.validationCarNameUnder5Length(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarValidationHandler.CAR_NAME_LENGTH_RESTRICTION);
    }

    @Test
    @DisplayName("문자열이 영어로만 이루어져 있으면 예외가 발생하지 않는다.")
    void isAlphaNumericOrAlphaOrNumericContainOnlyAlpha() {
        // given
        String carName = "pobi";

        // when // then
        CarValidationHandler.validationAlphaNumericOrAlphaOrNumeric(carName);
    }

    @Test
    @DisplayName("문자열이 영어와 숫자의 조합이면 있으면 예외가 발생하지 않는다.")
    void isAlphaNumericOrAlphaOrNumericContainAlphaNumeric() {
        // given
        String carName = "po123";

        // when // then
        CarValidationHandler.validationAlphaNumericOrAlphaOrNumeric(carName);
    }

    @Test
    @DisplayName("문자열이 숫자로만 이루어져 있으면 예외가 발생하지 않는다.")
    void isAlphaNumericOrAlphaOrNumericContainOnlyNumeric() {
        // given
        String carName = "12345";

        // when // then
        CarValidationHandler.validationAlphaNumericOrAlphaOrNumeric(carName);
    }

    @Test
    @DisplayName("문자열이 한글을 포함하면 예외가 발생한다.")
    void isAlphaNumericOrAlphaOrNumericFalse_한글() {
        // given
        String carName = "포비p1";

        // when // then
        assertThatThrownBy(() -> CarValidationHandler.validationAlphaNumericOrAlphaOrNumeric(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarValidationHandler.CAR_NAME_FORMAT_RESTRICTION);
    }

    @Test
    @DisplayName("문자열이 특수문자를 포함하면 예외가 발생한다.")
    void isAlphaNumericOrAlphaOrNumericFalse_특수문자() {
        // given
        String carName = "p.!@3";

        assertThatThrownBy(() -> CarValidationHandler.validationAlphaNumericOrAlphaOrNumeric(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarValidationHandler.CAR_NAME_FORMAT_RESTRICTION);
    }
}