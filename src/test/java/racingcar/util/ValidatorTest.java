package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {
    private Validator validator;

    @BeforeEach
    void init() {
        this.validator = new Validator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"one 1 1 11,t  wo2222", "어어어어어엄청나아아아게에에에기이이인이이이이르으으음, 나는 평범 해  "})
    void 자동차_이름_길이_테스트(String input) {
        List<String> names = Util.splitNameByComma(input);
        assertThatThrownBy(() -> validator.validateCarName(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_CAR_NAME_LENGTH.getMessage());
    }
}