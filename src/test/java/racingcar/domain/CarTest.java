package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void 랜덤_수가_4이상일때_카운팅하는_경우() {
        Car ford = new Car("ford");
        ford.move(5);
        assertThat(ford.getCount()).isEqualTo(1);

        Car bmw = new Car("bmw");
        bmw.move(3);
        assertThat(bmw.getCount()).isEqualTo(0);
    }
}
