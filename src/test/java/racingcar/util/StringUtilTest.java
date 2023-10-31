package racingcar.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringUtilTest {
    public static final String DELIMITER = ",";

    @Test
    void 구분자로_문자열을_리스트로_변환한다() {
        // given
        String carName1 = "pobi";
        String carName2 = "woni";
        String carName3 = "jun";
        String input = carName1 + DELIMITER + carName2 + DELIMITER + carName3;

        // when
        List<String> actual = StringUtil.convertToListByDelimiter(input);

        // then
        assertThat(actual).containsExactly(carName1, carName2, carName3);
        assertThat(actual).hasSize(3);
    }

    @Test
    void 문자열을_양의_정수로_변환한다() {
        // given
        String input = "1";

        // when
        int number = StringUtil.convertToPositiveInt(input);

        // then
        assertThat(number).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "a1", "123a"})
    void 문자열을_숫자로_변환할_수_없는_경우_예외가_발생한다(String input) {
        // when & then
        assertThatThrownBy(() -> StringUtil.convertToPositiveInt(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    void 문자열을_양의_정수로_변환할_수_없는_경우_예외가_발생한다(String input) {
        // when & then
        assertThatThrownBy(() -> StringUtil.convertToPositiveInt(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}