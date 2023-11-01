package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarNameValidatorTest {
    private final int NAME_LIMIT = 5;

    @ParameterizedTest
    @CsvSource(value = {"길이초초과과", "길이상당히초과"})
    void 이름_유효성_검사_length(String name) {
        assertThatThrownBy(() -> CarNameValidator.validateLengthCheck(name, NAME_LIMIT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름의 길이는 5를 초과할 수 없습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {" 공백포함", "공백  포함"}, ignoreLeadingAndTrailingWhitespace = false)
    void 이름_유효성_검사_공백(String name) {
        assertThatThrownBy(() -> CarNameValidator.validateSpaceCheck(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름에 공백이 존재할 수 없습니다.");
    }

    @Test
    void 중복된_이름이_존재할수_없다() {
        List<String> carNames = List.of("바보", "바보", "부부");
        assertThatThrownBy(() -> CarNameValidator.validateUniqueNameCheck(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름이 존재합니다.");
    }
}