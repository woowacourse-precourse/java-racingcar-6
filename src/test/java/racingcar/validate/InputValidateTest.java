package racingcar.validate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import racingcar.enums.ExceptionMessage;

class InputValidateTest {

    private final InputValidate inputValidate;

    InputValidateTest() {
        this.inputValidate = new InputValidate();
    }

    @Test
    void 이름_입력값_각각이_공백일_시_예외_처리() {

        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                inputValidate.validateNames(" , ,, "));
        assertEquals(ExceptionMessage.INPUT_NULL_EXCEPTION_MESSAGE.getValue(), exception.getMessage());
    }

    @Test
    void 이름_입력값_각각이_5글자가_넘으면_예외_처리() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                inputValidate.validateNames("abcdef"));
        assertEquals(ExceptionMessage.INPUT_LENGTH_EXCEPTION_MESSAGE.getValue(), exception.getMessage());
    }

    @Test
    void 시도_횟수_입력값이_int_범위_정수보다_크면_예외_처리() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                inputValidate.validateTrialNum("2200000000"));
        assertEquals(ExceptionMessage.INPUT_INTEGER_EXCEPTION_MESSAGE.getValue(), exception.getMessage());
    }

    @Test
    void 시도_횟수_입력값이_1_보다_작으면_예외_처리() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                inputValidate.validateTrialNum("0"));
        assertEquals(ExceptionMessage.INPUT_INTEGER_EXCEPTION_MESSAGE.getValue(), exception.getMessage());
    }
}