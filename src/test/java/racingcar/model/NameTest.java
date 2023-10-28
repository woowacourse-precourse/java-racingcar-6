package racingcar.model;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.exception.InvalidNameException;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class NameTest {

    @CsvSource({"abcdef", "123456"})
    @ParameterizedTest
    void 이름이_5글자를_초과하면_예외가_발생한다(String input) {
        // when & then
        assertThatThrownBy(() -> Name.from(input))
                .isInstanceOf(InvalidNameException.class);
    }

    @Test
    void 동일한_이름을_가진_Name_인스턴스는_동등하다() {
        // given
        Name result = Name.from("abc");
        Name expected = Name.from("abc");

        // when & then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 생성된_이름을_반환한다() {
        // given
        String input = "abc";
        Name result = Name.from(input);

        // when & then
        assertThat(result.getName()).isEqualTo(input);
    }
}
