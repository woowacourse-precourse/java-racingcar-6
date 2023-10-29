package racingcar.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class ValidatorTest {

    Validator validator = new Validator();

    @DisplayName("검증기 정상 동작 여부 테스트")
    @ValueSource(strings = {"Goooood", "baaaaaad", "555555"})
    @ParameterizedTest
    void validatorTest(String value) {
        assertThatThrownBy(() -> validator.valid(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

}