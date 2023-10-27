package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("자동차들 객체에 대해")
class CarsTest {

    @Test
    @DisplayName("자동차들의 수가 2보다 작은면 에러가 발생한다.")
    void validate_cars_count() {
        assertThatThrownBy(() -> new Cars("pobi"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
