package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Cars;

public class CarsTest {
    @Test
    @DisplayName("자동차 이름이 중복되면 실패")
    void validateUniqueCarName_실패() {
        assertThatThrownBy(() -> new Cars("pobi,wooni,pobi")).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "pobi,wooni,abcde"})
    @DisplayName("자동차 이름이 고유하면 성공")
    void validateUniqueCarName_성공(String input) {
        Cars cars = new Cars(input);
        assertThat(cars).isNotNull();
    }
}
