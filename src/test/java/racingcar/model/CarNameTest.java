package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarNameTest {

    @Test
    void 이름_자리_수_초과_예외_처리() {
        assertThatThrownBy(() -> {
            CarName name = new CarName("pobime");
        })
                .isInstanceOf(IllegalArgumentException.class);
    }
}
