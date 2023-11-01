package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    public void 자동차_생성_성공한다() {
        // given
        String name = "test1";

        // when
        Car car = new Car(name);

        // then
        assertThat(car).isNotNull();
    }
}