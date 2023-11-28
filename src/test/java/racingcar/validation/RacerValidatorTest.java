package racingcar.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Racer;

import static org.assertj.core.api.Assertions.assertThat;

public class RacerValidatorTest {
    // TODO: 추후 검증기 모아 한 클래스 에서 테스트
    @DisplayName("클래스 지원 테스트")
    @Test
    void checkSupport(){
        Validator validator = new RacerValidator();
        assertThat(validator.support(Racer.class)).isTrue();
    }
}
