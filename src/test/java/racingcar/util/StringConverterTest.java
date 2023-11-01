package racingcar.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringConverterTest {

    @Test
    @DisplayName("숫자로 구성된 문자열을 입력한 경우 정수 변환에 성공한다.")
    void toInteger_StringData_Success(){
        int data = 12345;
        int result = StringConverter.toInteger(String.valueOf(data));

        Assertions.assertThat(data).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("숫자가 아닌 값이 포함된 문자열을 입력한 경우 정수 변환에 실패한다.")
    @ValueSource(strings = {
            "12abc",
            "가나다라마바사",
            ",",
            ""
    })
    void toInteger_StringData_ThrowIllegalArgumentException(String data){
        assertThatThrownBy(() -> StringConverter.toInteger(data))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력한 수는 정수가 아닙니다.");
    }
}
