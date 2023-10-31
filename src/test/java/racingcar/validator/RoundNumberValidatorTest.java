package racingcar.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RoundNumberValidatorTest {

    @ParameterizedTest
    @CsvSource({"'-1234'", "'가나다'", "//////"})
    void 횟수에_문자가_있을때_예외_처리(String testInput) {
        Assertions.assertThatThrownBy(() -> RoundNumberValidator.validate(testInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("문자를 입력하였습니다.");
    }

    @ParameterizedTest
    @CsvSource({"''", "' '", "'  '"})
    void 횟수에_공백이_있을때_예외_처리(String testInput) {
        Assertions.assertThatThrownBy(() -> RoundNumberValidator.validate(testInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈칸입니다.");
    }
}
