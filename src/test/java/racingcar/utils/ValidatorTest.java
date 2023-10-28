package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.model.constants.Error.DUPLICATE;
import static racingcar.model.constants.Error.LENGTH_INVALID;
import static racingcar.model.constants.Error.NON_COMMA;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {
    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = new ValidatorImp();
    }

    @ParameterizedTest
    @DisplayName("자동차 이름 입력에 콤마가 없을 때, 길이를 초과할 때, 중복이 있을 때 예외 발생을 테스트 합니다.")
    @ValueSource(strings = {"pobi woni jun", "pobi123,woni,jun", "pobi,pobi,woni,jun"})
    void 자동차_이름_입력_통합_예외(String input) {
        assertThrows(IllegalArgumentException.class, () -> validator.validateCarName(input));
    }

    @Test
    @DisplayName("자동차 이름 입력에 콤마가 없을 때 예외 발생을 테스트 합니다.")
    void 자동차_이름_입력_콤마_예외() {
        String input = "pobi woni jun";

        assertThatThrownBy(() -> validator.validateCarName(input))
              .isInstanceOf(IllegalArgumentException.class)
              .hasMessageContaining(NON_COMMA.getMessage());
    }

    @Test
    @DisplayName("자동차 이름이 길이를 초과할 때 예외 발생을 테스트 합니다.")
    void 자동차_이름_입력_길이_예외() {
        String input = "pobi123,woni,jun";

        assertThatThrownBy(() -> validator.validateCarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LENGTH_INVALID.getMessage());
    }

    @Test
    @DisplayName("자동차 이름에 중복이 있을 때 예외 발생을 테스트 합니다.")
    void 자동차_이름_입력_중복_예외() {
        String input = "pobi,pobi,woni,jun";

        assertThatThrownBy(() -> validator.validateCarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE.getMessage());
    }
}
