package racingcar;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import racingcar.validator.RandomValidator;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RandomNumberTest {
    @Test
    void makeRandomNumber_0에서9까지의숫자_아닌경우_예외() {
        assertThatThrownBy(() -> RandomValidator.validateMakeRandomNumber(Arrays.asList(-1,0,9,10)));
    }
}