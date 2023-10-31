package racingcar.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.vo.CarName;
import racingcar.vo.TryNumber;

class StringConverterTest {

    private static final String EMPTY_INPUT_ERROR_MESSAGE = "입력값이 비어있습니다.";
    private static final String CHARACTERS_IN_INPUT_ERROR_MESSAGE = "입력값에 문자가 포함되어 있습니다";

    @DisplayName("자동차 이름 입력이 유효한 경우 리스트로 변환한다.")
    @Test
    void valid_stringToCarNameListByDelimiter_test() {
        // given
        String input = "Car1, Car2, Car3";
        List<CarName> expectedList = Arrays.asList(new CarName("Car1"), new CarName("Car2"), new CarName("Car3"));

        // when
        List<CarName> result = StringConverter.stringToCarNameListByDelimiter(input);

        // then
        assertEquals(expectedList, result);
    }

    @DisplayName("자동차 이름 입력이 빈 값인 경우 변환 과정에서 예외가 발생한다.")
    @Test
    void invalid_StringToListByDelimiter_exception_test() {
        String invalidInput = "";

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> StringConverter.stringToCarNameListByDelimiter(invalidInput));
        assertEquals(EMPTY_INPUT_ERROR_MESSAGE, e.getMessage());
    }

    @DisplayName("시도 횟수에 대해 유효한 입력인 경우 변환한다.")
    @Test
    void valid_StringToTryNumber_test() {
        // given
        String input = "123";
        TryNumber result = StringConverter.stringToTryNumber(input);

        // when
        Integer expectedResult = 123;

        // then
        assertEquals(expectedResult, result.number());
    }

    @DisplayName("시도 횟수가 문자열인 경우 변환 과정에서 예외가 발생한다.")
    @Test
    void invalid_StringToTryNumber_exception_test() {
        String invalidInput = "a";

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> StringConverter.stringToTryNumber(invalidInput));
        assertEquals(CHARACTERS_IN_INPUT_ERROR_MESSAGE, e.getMessage());
    }
}
