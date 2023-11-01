package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarNameTest {
    @Test
    void createCarNameByEmptySpace() {
        assertThatThrownBy(() -> new CarName("msung "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createByUnderLength() {
        assertThatThrownBy(() -> new CarName(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createByOverLength() {
        assertThatThrownBy(() -> new CarName("abcdefg"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
