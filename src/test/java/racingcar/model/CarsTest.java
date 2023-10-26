package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.utils.Constraints;

class CarsTest {
    @Test
    void 길이_초과_자동차명() {
        List<String> carNames = Arrays.asList("Hot", "HotFriedDelicious");

        assertThatThrownBy(() -> new Cars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 " + Constraints.MAX_SIZE.getValue() + "보다 작아야 합니다.");
    }
}