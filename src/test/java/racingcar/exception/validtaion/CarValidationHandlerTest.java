package racingcar.exception.validtaion;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarValidationHandlerTest {

    @Test
    @DisplayName("문자열이 5글자 이하이면 예외가 발생하지 않는다.")
    void validationCarNameUnder5Length() {
        // given
        String carName = "ppobi";

        // when // then
        CarValidationHandler.validationCarNameUnder5Length(carName);
    }

    @Test
    @DisplayName("문자열이 5글자 초과이면 예외가 발생한다.")
    void validationCarNameUnder5LengthException() {
        // given
        String carName = "ppobii";

        // when // then
        assertThatThrownBy(() -> CarValidationHandler.validationCarNameUnder5Length(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarValidationHandler.CAR_NAME_LENGTH_RESTRICTION);
    }

    @Test
    @DisplayName("문자열이 영어로만 이루어져 있으면 예외가 발생하지 않는다.")
    void validationAlphaNumericOrAlphaOrNumericContainOnlyAlpha() {
        // given
        String carName = "pobi";

        // when // then
        CarValidationHandler.validationAlphaNumericOrAlphaOrNumeric(carName);
    }

    @Test
    @DisplayName("문자열이 영어와 숫자의 조합이면 있으면 예외가 발생하지 않는다.")
    void validationAlphaNumericOrAlphaOrNumericContainAlphaNumeric() {
        // given
        String carName = "po123";

        // when // then
        CarValidationHandler.validationAlphaNumericOrAlphaOrNumeric(carName);
    }

    @Test
    @DisplayName("문자열이 숫자로만 이루어져 있으면 예외가 발생하지 않는다.")
    void validationAlphaNumericOrAlphaOrNumericContainOnlyNumeric() {
        // given
        String carName = "12345";

        // when // then
        CarValidationHandler.validationAlphaNumericOrAlphaOrNumeric(carName);
    }

    @Test
    @DisplayName("문자열이 한글을 포함하면 예외가 발생한다.")
    void validationAlphaNumericOrAlphaOrNumeric_한글() {
        // given
        String carName = "포비p1";

        // when // then
        assertThatThrownBy(() -> CarValidationHandler.validationAlphaNumericOrAlphaOrNumeric(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarValidationHandler.CAR_NAME_FORMAT_RESTRICTION);
    }

    @Test
    @DisplayName("문자열이 특수문자를 포함하면 예외가 발생한다.")
    void validationAlphaNumericOrAlphaOrNumeric_특수문자() {
        // given
        String carName = "p.!@3";

        assertThatThrownBy(() -> CarValidationHandler.validationAlphaNumericOrAlphaOrNumeric(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarValidationHandler.CAR_NAME_FORMAT_RESTRICTION);
    }

    @Test
    @DisplayName("자동차 이름이 저장되어 있는 List와 Set의 크기가 다르면 예외가 발생하지 않는다.")
    void validationDuplicatedCarNames() {
        // given
        String carName1 = "pobi1";
        String carName2 = "pobi2";

        // when // then
        CarValidationHandler.validationDuplicatedCarNames(List.of(carName1, carName2), Set.of(carName1, carName2));
    }

    @Test
    @DisplayName("자동차 이름이 저장되어 있는 List와 Set의 크기가 다르면 예외가 발생한다.")
    void validationDuplicatedCarNamesException() {
        // given
        String carName1 = "pobi";
        String carName2 = "pobi";

        // when // then
        assertThatThrownBy(() -> CarValidationHandler.validationDuplicatedCarNames(List.of(carName1, carName2),
                Set.of(carName1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarValidationHandler.CAR_NAME_DUPLICATED_RESTRICTION);
    }

    @Test
    @DisplayName("자동차 이름이 1개이면 예외가 발생하지 않는다.")
    void validationCarNamesOneSize() {
        // given
        String carName1 = "pobi1";
        String carName2 = "pobi2";

        // when // then
        CarValidationHandler.validationCarNamesOneSize(List.of(carName1, carName2));
    }

    @Test
    @DisplayName("자동차 이름이 1개이면 예외가 발생한다.")
    void validationCarNamesOneSizeException() {
        // given
        String carName = "pobi";

        // when // then
        assertThatThrownBy(() -> CarValidationHandler.validationCarNamesOneSize(List.of(carName)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarValidationHandler.MIN_CAR_NAMES_REQUIRED_RESTRICTION);
    }

    @Test
    @DisplayName("자동차 이름이 존재하면 예외가 발생하지 않는다.")
    void validationHasText() {
        // given
        String carName = "pobi";

        // when // then
        CarValidationHandler.validationHasText(carName);
    }

    @Test
    @DisplayName("자동차 이름이 존재하지 않으면 예외가 발생한다.")
    void validationHasTextException() {
        // given
        String carName = " ";

        // when // then
        assertThatThrownBy(() -> CarValidationHandler.validationHasText(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarValidationHandler.PROMPT_CAR_NAME_INPUT_RESTRICTION);
    }

    @Test
    @DisplayName("자동차 이름이 null이면  예외가 발생한다.")
    void validationHasTextExceptionNull() {
        // given
        String carName = null;

        // when // then
        assertThatThrownBy(() -> CarValidationHandler.validationHasText(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarValidationHandler.PROMPT_CAR_NAME_INPUT_RESTRICTION);
    }
}