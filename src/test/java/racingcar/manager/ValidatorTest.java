package racingcar.manager;


import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;
import static racingcar.Vars.LENGTH_CAR_NAME;

public class ValidatorTest {

    @Test
    void 이름의_길이_초과_예외_처리() {
        String longName = "verylongcarname";
        assertThatThrownBy(() -> Validator.validateCarNameLength(longName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LENGTH_CAR_NAME + "자 이하만 가능합니다.");
    }

}
