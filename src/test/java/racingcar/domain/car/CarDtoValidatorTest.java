package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarDtoValidatorTest {

    @Test
    @DisplayName("차 이름 입력값이 아예 없는 경우, 예외를 발생합니다.")
    void exceptNoneInputCase() {
        // GIVEN
        CarDto carDto = new CarDto(",,");
        String[] splittedCarNames = CarDtoValidator.getStrings(carDto);

        // WHEN
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            CarDtoValidator.applyValidationsOverCarNames(splittedCarNames, CarDtoValidator.validateNameLength);
        });

        // THEN
        assertEquals(CarDtoValidator.LENGTH_EXCEPTION_MESSAGE, thrown.getMessage());
    }

    @Test
    @DisplayName("차 이름 입력값이 1글자 미만인 경우, 예외를 발생합니다.")
    void exceptLeastOneCharCase() {
        // GIVEN
        CarDto carDto = new CarDto("as,,w");
        String[] splittedCarNames = CarDtoValidator.getStrings(carDto);

        // WHEN
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            CarDtoValidator.applyValidationsOverCarNames(splittedCarNames, CarDtoValidator.validateNameLength);
        });

        // THEN
        assertEquals(CarDtoValidator.LENGTH_EXCEPTION_MESSAGE, thrown.getMessage());
    }

    @Test
    @DisplayName("차 이름 입력값이 5자 글자 초과인 경우, 예외를 발생합니다.")
    void exceptMoreThanFiveCharsCase() {
        // GIVEN
        CarDto carDto = new CarDto("pobipobi,qwe,ert");
        String[] splitCarNames = CarDtoValidator.getStrings(carDto);

        // WHEN
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            CarDtoValidator.applyValidationsOverCarNames(splitCarNames, CarDtoValidator.validateNameLength);
        });

        // THEN
        assertEquals(CarDtoValidator.LENGTH_EXCEPTION_MESSAGE, thrown.getMessage());
    }

    @Test
    @DisplayName("차 이름 입력값 5자 글자 이하를 입력받습니다.")
    void acceptLessThanFiveCharsCase() {
        // GIVEN
        CarDto carDto = new CarDto("12345,1234,123,12,1");
        String[] splitCarNames = CarDtoValidator.getStrings(carDto);

        // WHEN
        // THEN
        assertDoesNotThrow(() -> {
            CarDtoValidator.applyValidationsOverCarNames(splitCarNames, CarDtoValidator.validateNameLength);
        });
    }

    @Test
    @DisplayName("차 이름 입력값에 숫자가 있으면 예외를 발생합니다.")
    void exceptNumber() {
        // GIVEN
        CarDto carDto = new CarDto("12345,1234,123,12,1");
        String[] splitCarNames = CarDtoValidator.getStrings(carDto);

        // WHEN
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            CarDtoValidator.applyValidationsOverCarNames(splitCarNames,
                    CarDtoValidator.validateNumber);
        });

        // THEN
        assertEquals(thrown.getMessage(), CarDtoValidator.NUMBER_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("차 이름 입력값에 특수문자가 있으면 예외를 발생합니다.")
    void exceptSpecialChar() {
        // GIVEN
        CarDto carDto = new CarDto("!@no,no)*,(n),+{,.");
        String[] splitCarNames = CarDtoValidator.getStrings(carDto);

        // WHEN
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            CarDtoValidator.applyValidationsOverCarNames(splitCarNames,
                    CarDtoValidator.validateSpecialChar);
        });

        // THEN
        assertEquals(thrown.getMessage(), CarDtoValidator.SPECIAL_CHAR_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("차 이름 입력값에 이모지가 있으면 예외를 발생합니다.")
    void exceptEmoji() {
        // GIVEN
        CarDto carDto = new CarDto("❤👫💸🗃,🤦‍♂,️👍🎉,👀");
        String[] splitCarNames = CarDtoValidator.getStrings(carDto);

        // WHEN
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            CarDtoValidator.applyValidationsOverCarNames(splitCarNames,
                    CarDtoValidator.validateEmoji);
        });

        // THEN
        assertEquals(thrown.getMessage(), CarDtoValidator.EMOJI_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("차 이름 입력값에 한글 혹은 영문만 있으면 정상적으로 통과합니다.")
    void acceptNumberAndSpecialChar() {
        // GIVEN
        CarDto carDto = new CarDto("이성문,성게,pobi,tony");

        // WHEN
        // THEN
        assertDoesNotThrow(() -> {
            CarDtoValidator.validateCarDto(carDto);
        });
    }
}