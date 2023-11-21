package racingcar.validation;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static racingcar.constant.ValidateMessage.CAR_NAME_CAN_NOT_BE_DUPLICATE;
import static racingcar.constant.ValidateMessage.CAR_NAME_INPUT_ERROR;
import static racingcar.constant.ValidateMessage.CAR_NAME_MUST_BE_LOWER_THAN_FIVE;
import static racingcar.constant.ValidateMessage.CAR_NAME_MUST_NOT_BE_NULL_OR_EMPTY;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarNameValidationTest {
    private final CarNameValidation carNameValidation;

    CarNameValidationTest() {
        carNameValidation = new CarNameValidation();
    }

    @DisplayName("자동차 이름이 빈 값인 경우 예외가 발생한다.")
    @Test
    void carNameOccurErrorWhenIsEmpty() {
        //given
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> carNameValidation.isNullOrEmpty(""));

        //then
        assertTrue(exception.getMessage().contains(CAR_NAME_MUST_NOT_BE_NULL_OR_EMPTY.message));
    }

    @DisplayName("자동차 이름이 null 값인 경우 예외가 발생한다.")
    @Test
    void carNameOccurErrorWhenIsNull() {
        //given
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> carNameValidation.isNullOrEmpty(null));

        //then
        assertTrue(exception.getMessage().contains(CAR_NAME_MUST_NOT_BE_NULL_OR_EMPTY.message));
    }

    @DisplayName("맨 앞 또는 맨 마지막에 콤마를 입력 할 수 없고 더블 콤마(,,)도 입력 할 수 없다.")
    @ParameterizedTest
    @CsvSource({"',,pobi,woni'", "',pobi,woni'", "'pobi,woni,'"})
    void checkCommaError(String input) {
        //given
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> carNameValidation.checkCommaError(input));

        //then
        assertTrue(exception.getMessage().contains(CAR_NAME_INPUT_ERROR.message));
    }

    @DisplayName("자동차 이름이 중복되면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"'pobi,woni,pobi'", "'pobi,woni , jun, jun'"})
    void checkDuplicate(String input) {
        //given
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> carNameValidation.checkDuplicate(input));

        //then
        assertTrue(exception.getMessage().contains(CAR_NAME_CAN_NOT_BE_DUPLICATE.message));
    }

    @DisplayName("자동차 이름이 5이상 이면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"'pobiii,woni'", "'pobi, woni, juniii'"})
    void checkCarNameLength(String input) {
        //given
        List<String> carNames = Arrays.asList(input.split(","));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> carNameValidation.checkCarNameLength(carNames));

        //then
        assertTrue(exception.getMessage().contains(CAR_NAME_MUST_BE_LOWER_THAN_FIVE.message));
    }
}