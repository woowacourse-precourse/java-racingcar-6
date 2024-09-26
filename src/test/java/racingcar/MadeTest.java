package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MadeTest {
    @Test
    void 자동차_이름_반환_테스트() {
        Car car = new Car("test");

        String name = car.getName();

        assertThat(name).isEqualTo("test");
    }

}
