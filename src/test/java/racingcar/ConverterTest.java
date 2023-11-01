package racingcar;

import Util.Converter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConverterTest {

    @Test
    void 숫자인_문자열을_정수로_변환() {
        String input = "123";
        int result = Converter.stringToInt(input);

        Assertions.assertThat(result).isEqualTo(123);
    }

//    @Test
//    void 숫자가_아닌_문자열을_정수로_변환() {
//        String input = "notNumber";
//
//        assertThrows(IllegalArgumentException.class, () -> Converter.stringToInt(input));
//    }
}
