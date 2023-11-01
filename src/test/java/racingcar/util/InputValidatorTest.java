package racingcar.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.util.ErrorMessage.*;

class InputValidatorTest {

    @Test
    void 자동차_이름_빈_문자열_예외테스트() {
        // given
        String testInput = "";

        // when, then
        Assertions.assertThatThrownBy(() -> InputValidator.validateCarsInput(testInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_INPUT_EMPTY_STRING.getMessage());
    }

    @Test
    void 자동차_이름_공백_예외테스트() {
        // given
        String testInput = "   ,    ,     ";

        // when, then
        Assertions.assertThatThrownBy(() -> InputValidator.validateCarsInput(testInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_INPUT_ONLY_SPACE_CAR_NAME.getMessage());

    }

    @Test
    void 자동차_이름_제한글자_예외테스트() {
        // given
        String testInput = "abcdefg,xyz,aaabbb";
        String testInput2 = "aabbcc";

        // when, then
        Assertions.assertThatThrownBy(() -> InputValidator.validateCarsInput(testInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_INPUT_EXCEED_NAME_LIMIT_LENGTH.getMessage());

        // when, then
        Assertions.assertThatThrownBy(() -> InputValidator.validateCarsInput(testInput2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_INPUT_EXCEED_NAME_LIMIT_LENGTH.getMessage());
    }

    @Test
    void 자동차_이름_중복_이름_예외테스트() {
        // given
        String testInput = "aabb,aabb,abc";

        // when, then
        Assertions.assertThatThrownBy(() -> InputValidator.validateCarsInput(testInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_INPUT_DUPLICATE_CAR_NAME.getMessage());
    }

    @Test
    void 시도횟수_숫자가_아닌_예외테스트() {
        // given
        String testInput = "";
        String testInput2 = "abcd";

        // when, then
        Assertions.assertThatThrownBy(() -> Converter.convertToValidInteger(testInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(TRY_COUNT_NOT_A_NUMBER.getMessage());

        // when, then
        Assertions.assertThatThrownBy(() -> Converter.convertToValidInteger(testInput2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(TRY_COUNT_NOT_A_NUMBER.getMessage());
    }

    @Test
    void 시도횟수_양수가_아닌_예외테스트() {
        // given
        String testInput1 = "0";
        String testInput2 = "-3";

        // when, then
        Assertions.assertThatThrownBy(() -> Converter.convertToValidInteger(testInput1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(TRY_COUNT_NOT_A_POSITIVE_INTEGER.getMessage());

        // when, then
        Assertions.assertThatThrownBy(() -> Converter.convertToValidInteger(testInput2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(TRY_COUNT_NOT_A_POSITIVE_INTEGER.getMessage());
    }

    @Test
    void 자동차_이름_검증_테스트() {
        // given
        String testInput = "aaaa,bbb,ccccc,dd,e";
        String testInput2 = "x,y,z";
        String testInput3 = "seung,gun,sin";

        // when, then
        assertDoesNotThrow(
                () -> InputValidator.validateCarsInput(testInput)
        );

        assertDoesNotThrow(
                () -> InputValidator.validateCarsInput(testInput2)
        );

        assertDoesNotThrow(
                () -> InputValidator.validateCarsInput(testInput3)
        );
    }

    @Test
    void 시도횟수_검증_테스트() {
        // given
        String testInput1 = "1";
        String testInput2 = "5";
        String testInput3 = "12";

        // when, then
        assertDoesNotThrow(
                () -> Converter.convertToValidInteger(testInput1)
        );

        assertDoesNotThrow(
                () -> Converter.convertToValidInteger(testInput2)
        );
        assertDoesNotThrow(
                () -> Converter.convertToValidInteger(testInput3)
        );
    }


}