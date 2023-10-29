package racingcar.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.vo.CarName;

class StringConverterTest {

    private static final String EMPTY_INPUT_ERROR_MSG = "입력값이 비어있습니다.";
    private static final String CHARACTERS_IN_INPUT_ERROR_MSG = "입력값에 문자가 포함되어 있습니다";

    @DisplayName("유효한 문자열을 구분자로 나누어 리스트로 변환한다.")
    @Test
    void stringToListByDelimiter_test() {
        // given
        String input = "Car1, Car2, Car3";
        List<CarName> expectedList = Arrays.asList(new CarName("Car1"), new CarName("Car2"), new CarName("Car3"));

        // when
        List<CarName> result = StringConverter.stringToCarNameListByDelimiter(input);

        // then
        assertEquals(expectedList, result);
    }

    @DisplayName("유효하지 않은 문자열을 정수로 변환하면 예외가 발생한다.")
    @Test
    void invalid_StringToListByDelimiter_exception_test() {
        String invalidInput = "";

        try {
            StringConverter.stringToInteger(invalidInput);
        } catch (IllegalArgumentException e) {
            assertEquals(EMPTY_INPUT_ERROR_MSG, e.getMessage());
        }
    }

    @DisplayName("유효한 문자열을 정수로 변환한다.")
    @Test
    void stringToInteger_test() {
        // given
        String input = "123";
        Integer result = StringConverter.stringToInteger(input);

        // when
        Integer expectedResult = 123;

        // then
        assertEquals(expectedResult, result);
    }


    @DisplayName("유효하지 않은 문자열을 정수로 변환하면 예외가 발생한다.")
    @Test
    void invalidStringToInteger_exception_test() {
        String invalidInput = "a";

        try {
            StringConverter.stringToInteger(invalidInput);
        } catch (IllegalArgumentException e) {
            assertEquals(CHARACTERS_IN_INPUT_ERROR_MSG, e.getMessage());
        }
    }
}