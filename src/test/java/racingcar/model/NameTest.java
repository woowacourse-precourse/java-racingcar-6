package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class NameTest {

    @CsvSource({"abcdef", "123456"})
    @ParameterizedTest
    void 이름이_5글자를_초과하면_예외가_발생한다(String input) {
        // when & then
        assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름이_같으면_같은_값으로_판단한다() {
        // given
        Name result = new Name("abc");
        Name expected = new Name("abc");

        // when & then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 이름을_반환한다() {
        // given
        String input = "abc";
        Name result = new Name(input);

        // when & then
        assertThat(result.getName()).isEqualTo(input);
    }
}
