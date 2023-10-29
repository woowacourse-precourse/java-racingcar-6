package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void 자동차_생성() {
        // given
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");

        // when, then
        assertThat(pobi.getName()).isEqualTo("pobi");
        assertThat(woni.getName()).isEqualTo("woni");
    }
}
