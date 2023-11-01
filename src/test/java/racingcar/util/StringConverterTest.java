package racingcar.util;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
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

    @DisplayName("시도 횟수에 대해 유효한 입력인 경우 변환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "12345"})
    void valid_StringToTryNumber_test(String input) {
        TryNumber tryNumber = assertDoesNotThrow(() -> StringConverter.stringToTryNumber(input));

        // when
        Integer expectedResult = Integer.valueOf(input);

        // then
        assertEquals(expectedResult, tryNumber.number());
    }
}
