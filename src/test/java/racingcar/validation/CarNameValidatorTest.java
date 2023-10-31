package racingcar.validation;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CarNameValidatorTest {
    @Test
    void 자동차_이름이_비어있는_경우_검증() {
        String input = ",car2,car3";
        List<String> carNames = Arrays.asList(input.split(","));
        assertThatThrownBy(() -> CarNameValidator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름이 공백이면 안됩니다.");
    }

    @Test
    public void 자동차_이름이_공백만_있는_경우_검증() {
        String input = "    ";
        List<String> carNames = Arrays.asList(input.split(","));
        assertThatThrownBy(() -> CarNameValidator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름이 공백이면 안됩니다.");
    }
}
