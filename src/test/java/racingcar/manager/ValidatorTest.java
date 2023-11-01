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

    @Test
    void 이름이_공백인_경우_예외_처리() {
        String longName = " ";
        assertThatThrownBy(() -> Validator.validateCarNameLength(longName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름의 길이는 1~" + LENGTH_CAR_NAME + "자만 가능합니다.");
    }

}
