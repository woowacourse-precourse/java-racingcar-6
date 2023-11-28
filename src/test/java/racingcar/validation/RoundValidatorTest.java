package racingcar.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Round;

import static org.assertj.core.api.Assertions.assertThat;
class RoundValidatorTest {
    @DisplayName("클래스 지원 테스트")
    @Test
    void checkSupport() {
        Validator validator = new RoundValidator();
        assertThat(validator.support(Round.class)).isTrue();
    }
}
