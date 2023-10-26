package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차_이름은_5자를_초과할_수_없음() {
        Assertions.assertThatThrownBy(() -> {
            new Car("abcdef");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다섯자_이하_이름의_자동차는_생성() {
        new Car("abcde");
    }

}