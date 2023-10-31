package racingcar.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Racer;

import static org.assertj.core.api.Assertions.assertThat;

class RacerValidatorTest {

    @DisplayName("클래스 지원 테스트")
    @Test
    void checkSupport() {
        Validator validator = new RacerValidator();
        assertThat(validator.support(Racer.class)).isTrue();
    }
}
