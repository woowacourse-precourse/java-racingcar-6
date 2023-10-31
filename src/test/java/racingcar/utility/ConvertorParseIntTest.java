package racingcar.utility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConvertorParseIntTest {

    @Test
    @DisplayName("String으로 숫자가 들어온다면 성공적으로 int로 변환한다.")
    void parseIntSuccessTest() {
        // given
        String string = "123";

        // when
        int result = Convertor.parseInt(string);
        int expectedResult = 123;

        // then
        Assertions.assertEquals(result, expectedResult);
    }

    @Test
    @DisplayName("String으로 숫자가 들어오지 않는다면 예외가 발생한다.")
    void parseIntFailTest() {
        // given
        String string = "가나다";

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Convertor.parseInt(string);
        });
    }

}
