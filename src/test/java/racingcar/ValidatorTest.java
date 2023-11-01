package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    public void 이름_유효성_테스트() throws Exception {
        String invalidateName = "abcdef";
        String validateName = "abcd";
        Assertions.assertThatThrownBy(() -> Validator.validateCarName(invalidateName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("올바르지 않은 이름입니다.");
        Assertions.assertThat(Validator.validateCarName(validateName)).isTrue();
    }

}