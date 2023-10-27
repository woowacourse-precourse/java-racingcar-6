package racingcar.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidInputTest {

    @Test
    @DisplayName("자동차 이름이 5글자를 넘어서면 오류가 나야 한다")
    void error_validCarNameLength() throws Exception {
        //given
        String carNames = "aaaaaa,bbb,cc,d";
        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> ValidInput.validCarNameLength(carNames));
    }

    @Test
    @DisplayName("자동차 이름이 5글자를 넘어서지 않으면 오류가 발생하지 않는다")
    void no_error_validCarNameLength() throws Exception {
        //given
        String carNames = "aaaaa,bbb,cc,dsd";
        //when

        //then
        assertDoesNotThrow(() -> ValidInput.validCarNameLength(carNames));
    }

    @Test
    @DisplayName("숫자가 아닌 값이 들어가면 오류가 발생한다")
    void error_validOnlyNumber() throws Exception {
        //given
        String input = "134f";
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> ValidInput.validOnlyNumber(input));
    }

    @Test
    @DisplayName("숫자값이 들어가면 오류가 발생하지 않는다")
    void no_error_validOnlyNumber() throws Exception {
        //given
        String input1 = "134";
        String input2 = "9";
        //when
        //then
        assertDoesNotThrow(() -> ValidInput.validOnlyNumber(input1));
        assertDoesNotThrow(() -> ValidInput.validOnlyNumber(input2));

    }
}