package racingcar.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Racer;

import static org.assertj.core.api.Assertions.assertThat;

class RacerValidatorTest {

    //TODO: 나중에 검증기 모아서 한 클래스에서 테스트 하는 것도 나쁘지 않을 뜻
    @DisplayName("클래스 지원 테스트")
    @Test
    void checkSupport() {
        Validator validator = new RacerValidator();
        assertThat(validator.support(Racer.class)).isTrue();
    }

}