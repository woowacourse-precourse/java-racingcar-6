package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
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
}
