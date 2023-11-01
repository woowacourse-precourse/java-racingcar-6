package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.Validator;

class ValidatorTest {
    final Validator validator = Validator.getInstance();

    @Test
    @DisplayName("예외 - 자동차 이름을 입력하지 않는다.")
    void test1() {
        //given
        final String name = "";

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> validator.carNames(name));
    }
}
