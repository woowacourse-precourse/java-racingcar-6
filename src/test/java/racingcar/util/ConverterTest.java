package racingcar.util;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class ConverterTest {

    @Test
    void 문자열을_콤마로_나누어_리스트로_변환한다() {
        // given
        String text = "apple,banana,orange,grape";

        // when
        List<String> result = Converter.splitWithCommaAndConvertToList(text);

        // then
        assertSoftly(softly -> {
            softly.assertThat(result).hasSize(4);
            softly.assertThat(result).containsExactly("apple", "banana", "orange", "grape");
        });
    }
}
