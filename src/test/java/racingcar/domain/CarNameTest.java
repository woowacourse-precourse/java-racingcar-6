package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarNameTest {
    @Test
    void 자동차이름_길이는_5이상이다(){
        assertThatThrownBy(() -> new CarName("LengthIsOver5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 차이름은_공백으로만_이루어질수_없다(){
        assertThatThrownBy(() -> new CarName("   "))
                .isInstanceOf(IllegalArgumentException.class);
    }
}