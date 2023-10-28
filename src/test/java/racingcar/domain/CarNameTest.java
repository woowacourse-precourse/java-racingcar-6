package racingcar.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {
    @Test
    void createCarNameByEmptySpace(){
        assertThatThrownBy(() -> new CarName("msung99 "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createByUnderLength(){
        assertThatThrownBy(() -> new CarName(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createByOverLength(){
        assertThatThrownBy(() -> new CarName("abcdefg"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
