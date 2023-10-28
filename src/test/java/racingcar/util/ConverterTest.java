package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.exception.NonPositiveIntException;


class ConverterTest {

    @Test
    void 문자열을_콤마를_기준으로_분리하여_리스트를_만들어준다() {
        // given
        String input = "A,B,C";

        // when
        List<String> result = Converter.convertCommaSeparatedStringToList(input);

        // then
        assertThat(result).containsExactly("A", "B", "C");
    }

    @CsvSource({"10, 10", "100, 100", "999, 999"})
    @ParameterizedTest
    void 문자열을_양의_정수로_바꾸어준다(String input, int expected) {
        // when
        int result = Converter.convertStringToPositiveInt(input);

        // when & then
        assertThat(result).isEqualTo(expected);
    }


    @CsvSource({"ABC", "-1", "0"})
    @ParameterizedTest
    void 문자열이_잘못된_값으로_들어오면_예외가_발생한다(String input) {
        // then & then
        assertThatThrownBy(() -> Converter.convertStringToPositiveInt(input))
                .isInstanceOf(NonPositiveIntException.class);
    }
}
