package convert;

import static org.assertj.core.api.Assertions.*;

import enums.ErrorMessages;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import util.convertor.StringToIntConvertor;

public class StringToIntConvertorTest {

    @ParameterizedTest
    @DisplayName("문자열 정수로 변환 테스트")
    @CsvSource({"'1', 1", "'2', 2", "'3', 3", "'4', 4", "'5', 5", "'6', 6", "'7', 7", "'8', 8"})
    void StringToIntConvertorTest(String input, int expected) {
        //when
        int result = StringToIntConvertor.convert(input);

        //then
        assertThat(result).isEqualTo(expected);
    }


    @ParameterizedTest
    @DisplayName("문자열 정수로 변환시 예외처리 테스트")
    @ValueSource(strings = {"a,b,c,d,e,f,g"})
    void StringToIntConvertorExceptionTest(String input) {

        assertThatThrownBy(() -> StringToIntConvertor.convert(input)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(
                ErrorMessages.INVALID_INTEGER_INPUT_MESSAGE.getMessage());
    }
}
