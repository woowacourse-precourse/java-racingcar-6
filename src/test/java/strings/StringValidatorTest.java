package strings;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import strings.util.StringValidator;

final class StringValidatorTest {

    @DisplayName("null이나 공백 이외의 문자가 포함된 문자열 입력 시 검증 성공")
    @Test
    void validateString_withNonNullOrIncludesNonWhitespaces_shouldBeOk() {
        // given
        final List<String> inputs = List.of(
                " x",
                "\to",
                "z\n",
                "l\r"
        );
        // when
        // then
        inputs.forEach(StringValidator::validateString);
    }

    @DisplayName("null 입력 시 예외 발생")
    @Test
    void validateString_withNull_shouldThrowException() {
        // given
        final String input = null;
        // when
        // then
        assertThatThrownBy(
                () -> StringValidator.validateString(input)
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("null이거나 공백인 문자열을 사용할 수 없습니다.");
    }

    @DisplayName("공백인 문자열 입력 시 예외 발생")
    @Test
    void validateString_includesWhitespaces_shouldThrowException() {
        // given
        final List<String> inputs = List.of(
                " ",
                "\t",
                "\n",
                "\r",
                "\r   ",
                "\n   "
        );
        // when
        // then
        inputs.forEach(input -> {
            assertThatThrownBy(
                    () -> StringValidator.validateString(input)
            )
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("null이거나 공백인 문자열을 사용할 수 없습니다.");
        });
    }


}